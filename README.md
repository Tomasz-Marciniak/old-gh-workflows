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