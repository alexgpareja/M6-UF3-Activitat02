# M6-UF3-Activitat02

## Millores i preguntes de reflexió

### 1. Afegiu un endpoint que cerqui per un camp de tipus String on feu servir regex. Afegiu el que calgui al servei, repositori, etc.

S'ha afegit un endpoint GET que permet cercar entitats pel camp `nom` usant una expressió regular.  
Exemple de mètode al repositori:

```java
@Query("{ 'nom': { $regex: ?0, $options: 'i' } }")
Flux<Entitat> findByNomRegex(String regex);
```

---

### 2. Què caracteritza una API reactiva com aquesta i què la fa diferent d’una API síncrona amb MVC com les treballades anteriorment?

Una API reactiva és **no bloquejant** i **asíncrona**, ideal per escalar amb poques connexions.  
Una API MVC és **bloquejant** i assigna un fil per petició, menys eficient en alta concurrència.

---

### 3. Què signifiquen Mono i Flux? Per a què penseu que serveixen i per què són útils en aquest tipus de programació?

- `Mono`: 0 o 1 resultat.
- `Flux`: 0 o més resultats.  
Són útils per treballar amb dades asíncrones i fer operacions reactives de manera eficient.

---

### 4. Què és record? Un record utilitza getters i setters? Justifiqueu la resposta

Un `record` és una classe immutable amb getters automàtics (sense `get`).  
**No té setters** perquè els camps són finals. Ideal per representar dades fixes com DTOs.

