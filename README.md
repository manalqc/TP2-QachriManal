# TP2GithubActions

Projet Android (Kotlin, API 21+) prêt pour le TP2 GitHub Actions. Il contient :
- une activité simple affichant un message "Bonjour depuis TP2 + GitHub Actions !";
- un test unitaire `addition_isCorrect` dans `app/src/test/java/com/example/tp2githubactions/ExampleUnitTest.kt`;
- le workflow CI Android qui build + lance les tests unitaires.

## Workflow CI
Fichier : `.github/workflows/android-ci.yml`
- déclenchement : push/PR sur `main`;
- JDK 17 + cache Gradle;
- build complet `./gradlew build`;
- tests unitaires `./gradlew :app:testDebugUnitTest`.

## Captures attendues
Place-les dans `captures/` :
- écran de l’app ou preview;
- workflow success;
- workflow failed (test KO sur la PR);
- workflow success après correction.

## Scénario PR (tests KO puis OK)
1. Créer la branche : `git checkout -b feature-tests`.
2. Modifier un texte (ex. `activity_main.xml`) et pousser :
   ```bash
   git add .
   git commit -m "Modification de l'interface sur feature-tests"
   git push -u origin feature-tests
   ```
3. Ouvrir la PR vers `main` sur GitHub (le workflow doit passer ✅).
4. Casser volontairement le test : dans `ExampleUnitTest.kt`, changer `2 + 2` en `2 + 1`, puis :
   ```bash
   git add app/src/test/java/com/example/tp2githubactions/ExampleUnitTest.kt
   git commit -m "Rendre le test unitaire KO pour le TP2"
   git push
   ```
   Le workflow sur la PR doit échouer ❌.
5. Corriger le test (remettre `2 + 2`) puis :
   ```bash
   git add app/src/test/java/com/example/tp2githubactions/ExampleUnitTest.kt
   git commit -m "Correction du test unitaire"
   git push
   ```
   Le workflow repasse au vert ✅, tu peux merger la PR.

## Commandes Git de base
- Initialisation après clonage :
  ```bash
  git status
  git add .
  git commit -m "Remplacement du projet Python par l'application Android"
  git push
  ```
- Lancer le workflow localement : `./gradlew test` (ou `gradlew.bat test` sous Windows).

## Stack technique
- Android Gradle Plugin 8.2.2
- Gradle 8.2.1 (wrapper inclus)
- Kotlin 1.9.22
- Min SDK 21 / Target SDK 34
