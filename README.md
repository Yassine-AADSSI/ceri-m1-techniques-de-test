# UCE Génie Logiciel Avancé : Techniques de tests
# AADSSI Yassine : M1 ILSEN ALT GRP 2

[![codecov](https://codecov.io/gh/Yassine-AADSSI/ceri-m1-techniques-de-test/branch/master/graph/badge.svg?token=53O5CE6VTC)](https://codecov.io/gh/Yassine-AADSSI/ceri-m1-techniques-de-test)

[![CircleCI](https://dl.circleci.com/status-badge/img/gh/Yassine-AADSSI/ceri-m1-techniques-de-test/tree/master.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/gh/Yassine-AADSSI/ceri-m1-techniques-de-test/tree/master)

[![Checkstyle](https://github.com/Yassine-AADSSI/ceri-m1-techniques-de-test/blob/master/docs2/badges/checkstyle-result.svg)](https://htmlpreview.github.io/?https://github.com/Yassine-AADSSI/ceri-m1-techniques-de-test/blob/master/docs2/checkstyle/checkstyle.html)

[![Javadoc](https://camo.githubusercontent.com/cdb121b67e21b6ad3795840572a5303e3aae40f623666b170c9824a33a67ad38/68747470733a2f2f6a617661646f632e696f2f6261646765322f6f72672e737072696e676672616d65776f726b2f737072696e672d636f72652f6a617661646f632e737667)](https://yassine-aadssi.github.io/ceri-m1-techniques-de-test/fr/univavignon/pokedex/api/package-summary.html)


### Rapport : 

Le test testCreatePokemon ne couvre pas la nouvelle implémentation de IPokemonFactory car le nom du Pokémon "Bulbizarre" ne correspond pas au nom renvoyé par la MAP ("MISSINGNO"). Dans ma propre implémentation, j'ai utilisé un nom différent de celui utilisé par la Team Rocket. En réalité, la Team Rocket utilise trois noms de Pokémon constants : "Ash's Pikachu", "MISSINGNO" et "Bulbasaur". Lorsque l'index passé en paramètre est 0, le Pokémon doit être nommé "MISSINGNO" (l'index 1 correspond à "Bulbasaur" et l'index -1 correspond à "Ash's Pikachu").Donc, pour remédier à cette situation, j'ai implémenté une nouvelle classe de tests dédiée à la classe développée par la Team Rocket.
