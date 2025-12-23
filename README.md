# GitHub Workflows

A collection of reusable [GitHub Actions](https://docs.github.com/en/actions) workflows designed to be shared across repositories.

This repository provides production-ready workflows to standardize automation such as CI, testing, and releases.

## Getting started

Reusable workflows are referenced from other repositories using the `uses` keyword.

Example:

```yaml

name: Example project pipeline

on:
  workflow_dispatch:
  push:
    branches:
      - 'main'
    tags:
      - "v*.*.*"
  pull_request:
    branches:
      - 'main'

jobs:
  ci:
    permissions:
      contents: write
      pull-requests: write
      packages: write
      
    uses: upfera/gh-workflows/.github/workflows/ci.yml@v0.1.0
```

The referenced workflow in this respository must be configured with `on: workflow_call`.

### Release

This repository uses [release-please-action](https://github.com/googleapis/release-please-action) as a separate pipeline that reacts on merge to the main branch to automate versioning and changelog generation.

### 🔐 Authentication Note

This project currently uses the default `GITHUB_TOKEN` for GitHub Actions authentication, as it provides short-lived, repository-scoped credentials and is the recommended approach for most automation scenarios.

However, `GITHUB_TOKEN` has an important limitation: actions performed with it (such as creating pull requests or releases) do **not** trigger additional workflows. This is an intentional safeguard by GitHub to prevent recursive executions.

For use cases that require workflow chaining (e.g. triggering CI from automated release pull requests), this project also supports using a **Personal Access Token (PAT)** or a **GitHub App**. While PATs are simpler to set up, GitHub Apps are the preferred long-term solution for secure and auditable automation.

### Troubleshooting

**Error:** release-please failed: GitHub Actions is not permitted to create or approve pull requests

**Cause:** The workflow lacks permission to create or approve PRs.

**Solution:**
1. Go to repository Settings → Actions → General → Workflow permissions.
2. Enable "Allow GitHub Actions to create and approve pull requests."

**Note:** Using a Personal Access Token (PAT) is possible but **not recommended** for bot actions due to security and auditing reasons.

## Background

Maintaining consistent CI/CD and automation across multiple repositories is challenging and error-prone. 
GitHub reusable workflows enable teams to centralize logic, reduce duplication, and evolve automation in one place.

This repository serves as a shared toolbox of reusable workflows that can be referenced from other repositories, helping teams:
- standardize automation
- reduce boilerplate
- improve maintainability
- and apply the best practices consistently.

## Contributing

Contributions are welcome. More details will be added as the project evolves.

## License

GitHub Workflows is Open Source software released under the Apache 2.0 license