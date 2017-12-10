# Elm
## En introduksjon
#### Morten Nygaard Åsnes

---

### Hva er Elm
- Kompilert til JavaScript
- Funksjonelt
- Statisk typet
- Frontend rammeverk

Note:
Elm er for mennesker, JavaScript er for maskiner
Ingen sideefekter.
Funksjoner er førsteklasses objekter.
JavaScript fatigue
React / Redux
Shadow Dom

---

### Hvorfor Elm
- Sikkert
- Stabilit
- Refaktorering
- Typesystem

Note:
Typesystem
Ingen null verdier
Feilmeldinger
Elm kompilatoren gjør kjøretidsfeil om til kompileringsfeil


---

### Funksjoner
```elm
sayHello : String -> String
sayHello name =
  "Hello, " ++ name ++ "!"
```
@[2-3]
@[1]

---
### Rekursive Funksjoner
```elm
fibonacci : Int -> Int
fibonacci n =
  if n == 0 then
    0
  else if n == 1 then
    1
  else
   fibonacci (n - 1) + fibonacci (n - 2)
```
@[1-4]
@[1-2,5-6]
@[1-2,7-8]
---
### Records
```elm
card =
  { suit = "Spades"
  , rank = "Ace"
  }

toString : { suit : String, rank : String } -> String
toString card =
  card.rank ++ " of " ++ card.suit
```
@[1-4]
@[6-8]

---
### Type Alias
```elm
type alias Card =
  { suit : String
  , rank : String
  }

toString : Card -> String
toString card =
  card.rank ++ " of " ++ card.suit
```
@[1-4]
@[6-8]
---
### Union Types
```elm
type Suit = Clubs | Diamonds | Hearths | Spades

type Rank = Face Name | Value Int
type Name = Ace | Jack | Queen | King

type alias Card =
  { suit : Suit
  , rank : Rank
  }
```
@[1]
@[3-4]
@[6-9]
---
### Handling Union Types
```elm
print : Card -> String
print card =
  case card.rank of
    Value value ->
      toString value ++ " of " ++ toString card.suit

    Face name ->
      toString name ++ " of " ++ toString card.suit
```
@[1-5]
@[1-2,7-8]
---
### Handling Union Types
```elm
value : Card -> Int
value card =
  case card.rank of
    Value value ->
      value

    Face name ->
      case name of
        Ace -> 1
        Jack -> 11
        Queen -> 12
        King -> 13
```
@[1-5]
@[1-2,7-12]
---
### Higher Order functions
```elm
sum : List Card -> Int
sum cards =
  foldl (+) 0 (map (\c -> value c) cards)
```
---
---?image=handling-user-input_01.png&size=auto 60%
---
[Ellie](https://ellie-app.com/3wwM4XmnBa1/0)

---
Topics:
- Hva er elm
	- Statisk typet
	- Funksjonelt
	- Kompilerer til JavaScript
	- Elm Arkitekturen
	  - Frontend
		- Shadow Dom
		- React / Redux
- Hvorfor elm
	- Sikkerhet
	- Stabilitet
	- Brukervenlig
	- Feilmeldinger
	- Refaktorering
	- Typer
	- Uten null verdier
- Eksempel
	- Funksjoner
	- Typer
	- Arkitekturen



- test
- test 2
	- test 3

---

```elm
type alias Card =
  { suit : String
  , value : Int
  }
```
https://ellie-app.com/3wwM4XmnBa1/0
https://ellie-app.com/3wwM4XmnBa1/1
