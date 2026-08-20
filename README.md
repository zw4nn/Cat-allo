# CAT’Allo v0.1.0

Application Android professionnelle pour retrouver rapidement du matériel et suivre les chantiers.

## Version
- versionName : 0.1.0
- versionCode : 1
- applicationId : fr.catallo.app

## Identité visuelle
Logo catalogue + éclair, interface sombre et accent rose.

## GitHub
Le workflow `.github/workflows/build-catallo.yml` compile automatiquement l'APK à chaque push sur `main`.

## Important pour les mises à jour Android
Pour qu'une APK puisse mettre à jour la précédente, il faut conserver le même `applicationId`
et signer les futures versions avec la même clé de signature.
