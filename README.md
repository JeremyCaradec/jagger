## Projet Compilation
#### Binôme: Jeremy Caradec et Alexandre Lebegue

Ce projet nous tenait beaucoup à coeur et nous nous sommes énormément donnés sur le peu de temps que l'on avait pour lui.
Nous n'avons malheureusement pas pu parvenir au bout du projet bien que nous sommes persuadés qu'avec un peu plus de temps nous y serons parvenus.

Les difficultées rencontrées étaient variées, mais je pense que le binding était de loin la plus grosse à laquelle nous avons été confrontés. Nous étions partit sur quelque chose de "sale" au départ, avec une liste de Scope en public static. Comme nous utilisons des threads, ça ne pouvait pas fonctionner, et nous ne voulions pas rajouter un mutex puisque ça n'aurait été que boucher la fuite avec du scotch. Nous avons donc remanié le fonctionnement de Scope pour quelque chose de plus élégants où les Scope ont uniquement besoin de savoir qui est leur parent.

## Utilisation

make pour compiler.
make check pour lancer tous les fichiers de tests.
