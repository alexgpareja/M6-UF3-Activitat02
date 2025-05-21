# Activitat A02 - UF3 M06: API Reactiva amb Spring Boot i MongoDB

## Objectiu de l'activitat

En aquesta activitat, hem creat una **API Reactiva** que interactua amb una base de dades MongoDB mitjançant **Spring Boot** i **Spring WebFlux**. Hem utilitzat **DTOs** per a la comunicació entre el client i el servidor i hem implementat la seva conversió mitjançant **MapStruct**. 


## Millores i preguntes de reflexió

### 1. Afegiu un endpoint que cerqui per un camp de tipus String on feu servir regex. Afegiu el que calgui al servei, repositori, etc.

Per implementar aquest endpoint que cerca per un camp `String` mitjançant una expressió regular, cal fer el següent:

- **Repositori** (usant Spring Data Reactive amb MongoDB, per exemple):

```java
@Query("{ 'nom' : { $regex: ?0, $options: 'i' } }")
Flux<Entitat> findByNomRegex(String regex);
```

- **Servei**:

```java
public Flux<Entitat> cercarPerNom(String regex) {
    return repositori.findByNomRegex(regex);
}
```

- **Controlador**:

```java
@GetMapping("/cerca")
public Flux<Entitat> cercaPerNom(@RequestParam String nom) {
    return servei.cercarPerNom(nom);
}
```

Aquesta funcionalitat permet cercar entitats que continguin un cert patró dins del camp `nom`, amb cerca insensible a majúscules/minúscules (`$options: 'i'`).

---

### 2. Què caracteritza una API reactiva com aquesta i què la fa diferent d’una API síncrona amb MVC com les treballades anteriorment?

Una API **reactiva** es caracteritza per:

- Ser **no bloquejant**, cosa que permet atendre moltes peticions amb pocs recursos.
- Treballar de forma **asíncrona**, gestionant fluxos de dades amb **`Mono` i `Flux`**.
- Estar pensada per escalar millor, especialment en entorns amb alta concurrència.
- Fer servir el model de programació **reactiva** basat en la propagació d'esdeveniments.

En canvi, una API **síncrona amb MVC**:

- És **bloquejant**: cada petició consumeix un fil fins que es resol.
- Té una estructura més tradicional, fàcil d'entendre, però menys eficient per a aplicacions que gestionen moltes connexions simultànies.
- No està pensada per treballar amb fluxos de dades ni operacions reactives.

---

### 3. Què signifiquen Mono i Flux? Per a què penseu que serveixen i per què són útils en aquest tipus de programació?

- **`Mono<T>`**: representa una emissió de **0 o 1 element**. Es fa servir quan esperem una sola resposta, com recuperar una entitat per ID.
- **`Flux<T>`**: representa una emissió de **0 o més elements**. És útil per a col·leccions, fluxos de dades o respostes múltiples.

Serveixen per gestionar dades de manera **reactiva** i **asíncrona**. Són útils perquè:

- Permeten composició i manipulació declarativa del flux de dades.
- Afavoreixen un model no bloquejant que millora la rendibilitat.
- Són compatibles amb la gestió d’errors i operacions encadenades de forma clara i eficaç.

---

### 4. Què és record? Un record utilitza getters i setters? Justifiqueu la resposta

Un **`record`** en Java és una classe especial introduïda a partir de Java 14 (estable en Java 16) que serveix per declarar **dades immutables** de forma concisa.

- **No utilitza setters**, ja que els camps són finals (immutables).
- **Sí genera getters**, però aquests no tenen el prefix `get`. Es generen automàticament amb el mateix nom que el camp.

Exemple:

```java
public record Alumne(String nom, int edat) {}
```

Aquest `record` genera:

- Un constructor
- Getters: `nom()` i `edat()`
- Mètodes `equals()`, `hashCode()` i `toString()`

És ideal per a DTOs i estructures de dades immutables, especialment útils en programació funcional i reactiva.

## Proves amb Swagger

### 1. Crear un cotxe

<img width="1454" alt="image" src="https://github.com/user-attachments/assets/47192ad4-6b5a-4149-94af-0f3b370a8363" />

URL: /api/cotxes/save

Mètode HTTP: POST

Descripció: Aquest endpoint rep un DTO de Cotxe i el guarda a la base de dades.

Paràmetres: El cos de la petició ha de contenir un objecte CotxeDTO amb la informació del cotxe a crear.

Resposta: Retorna un Mono amb el cotxe creat.

### 2. Obtenir un cotxe per ID

<img width="1463" alt="image" src="https://github.com/user-attachments/assets/ff43ce88-c9a6-40a3-b9c7-e6db967b6c61" />

URL: /api/cotxes/{id}

Mètode HTTP: GET

Descripció: Obté un Cotxe per ID des de la base de dades.

Paràmetres: El paràmetre {id} és l'ID del cotxe que es vol obtenir.

Resposta: Retorna un Mono amb el Cotxe que coincideix amb l'ID.

### 3. Llistar tots els cotxes

<img width="1455" alt="image" src="https://github.com/user-attachments/assets/a23af397-fdd9-49a8-ad0f-e4621f48b945" />

URL: /api/cotxes/all

Mètode HTTP: GET

Descripció: Llista tots els cotxes disponibles a la base de dades.

Resposta: Retorna un Flux amb tots els Cotxes.

### 4. Actualitzar un cotxe existent

<img width="1461" alt="image" src="https://github.com/user-attachments/assets/e3f8b1a7-a66f-4b54-ab36-36ac91ff027d" />

URL: /api/cotxes/update

Mètode HTTP: PUT

Descripció: Actualitza un Cotxe existent basant-se en el DTO enviat.

Paràmetres: El cos de la petició ha de contenir un objecte CotxeDTO amb la nova informació del cotxe.

Resposta: Retorna un Mono amb el cotxe actualitzat.

### 5. Cercar cotxes per model que comencin amb una lletra

<img width="1497" alt="image" src="https://github.com/user-attachments/assets/9df1f3a1-28be-4483-bc5b-01173a2951f7" />

URL: /api/cotxes/search/startswith/{letter}

Mètode HTTP: GET

Descripció: Aquest endpoint cerca tots els cotxes amb el model que comencen amb una lletra específica.

Paràmetres: El paràmetre {letter} és la lletra amb què comença el model del cotxe.

Resposta: Retorna un Flux amb els Cotxes que coincideixen amb el criteri de cerca.

### 6. Eliminar un cotxe per ID

<img width="1472" alt="image" src="https://github.com/user-attachments/assets/1fcf09d4-c8d0-4a73-8ba8-c3e32e780f20" />

URL: /api/cotxes/delete/{id}

Mètode HTTP: DELETE

Descripció: Elimina un Cotxe per ID des de la base de dades.

Paràmetres: El paràmetre {id} és l'ID del cotxe a eliminar.

Resposta: Retorna un Mono buit indicant que l'operació ha acabat.

