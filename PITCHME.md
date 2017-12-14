# Kotlin
## En introduksjon
#### Morten Nygaard Åsnes

Note:
Om Meg selv; Jobber som konsulent i Webstep. Er for tiden i oppdrag på TV2, hvor jeg har vært i bort i mot 3 år nå. Jobber
med back end Java utvikling. Har jobbet på Java platformen i mange år, og har vært litt borti Clojure og Scale. Men selv om
begge de språkene kan sies å være kraftigere på hver sin måte, seiler Kotlin opp som å være den største utfordreren til 
å bli det største main stream språket på Jvm platformen. Mye skyldes at Designet av språket har vært lagt opp til å
ikke være alt for ulikt Java, og ikke minst at enkel interrop med Java har vært høyt prioritet.
Kotlin har spesielt etablert seg som den største utfordreren til Java på Android platformen. Mye pga at java 
for Android har hengt langt bak standard Java når det kommer til nye features for funksjonell programmering, har Kotlin etablert seg som de facto alternativet 
til Java. Kotlin er nå også ofisielt støttet av google til Android programmering, på linje med Java.
Men også på server utvikling blir Kotlin mer populært. Det er nå offisielt støttet av spring og spring boot, som alternativ til
Java. Og det er ikke uvanlig at nye rammeverk nå kommer med tilpasset Kotlin støtte i tilleg til Java.
Kotlin har hatt som mål å være et mer konsist, mindre verbost alternativ til Java, og egner seg spesielt
til å utvikle DSL'er i.



---
## Historie
- Statisk typet programmeringsspråk
  - JVM
  - JavaScript
  - Native (LLVM)
- Multi Paradigm
- JetBrains
Note:
Java er et statisk typet språk, og det egner seg like bra til funksjonell programmering som objekt orientert programmering.
Utviklet av JetBrains som et alternativ til Java på Jvm platformen, men kompilerer nå også til JavaScript, og native (via LLVM)
Språket er med hensikt mindre verbost en Java, og har ikke overraskende utmerket IDE støtte i IntelliJ 
Selv har jeg hovedsaklig brukt Kotlin til hobby prosjekter. Men har også klart å snike det inn til enkelte oppgaver på jobben.
Kotlin har en stor fordel ved at java interopp er utmerket, og at det fungerer problemfritt inn i eksisterende bygge og deployment 
pipelines. 



---
## Funksjoner
```kotlin
fun main(args: Array<String>) {
    println("Hello, World!")
}

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

fun sum(a: Int, b: Int) = a + b
```
Note:
I Motsetning til Java er ikke Kotlin sentrert rundt klasser, men filer.
En funksjon i Kotlin trenger ikke 
tilhøre en klasse. (Men behind the scenes kompileres filene til klasser).
Et minimalt Kotlin program trenger kun en top level main funksjon.
På samme måte som i Java tar vi inn programm argumentene som en liste.
Retur type kan unnlates om den er Unit (void) som i dette tilfellet.
Funksjoner defineres med nøkkelordet 'fun' uavhengig av om det er en enkeltsående funksjon
eller en metode i en klasse.
Ellers kan den også unlates dersom den kan utledes automatisk. 
Type kommer etter parameter/argument i typesignaturen.
Int typen her er helt kompatibel med Java Integer, og kan brukes direkte mot java funksjoner. Men har også flere
ekstra metoder.
Legg merke til at 'if' er en expression.
Om funksjonen består av en enkelt expression kan den skrives med = uten klammer.
Returtypen kan også unnlates om den kan utledes. Semicolons are optional.
Default parameter
Named parameters
Extension functions



---
## Variabler
#### Immutable
```kotlin
val a: Int = 1 
val b = 2
val c: Int  
c = 3
```
#### Mutable
```kotlin
var sum: Int = 0 
sum = a + b

var s = "$sum = ${a + b}"
```
Note:
'val' definerer en immutable variabel. Om typen kan utledes kan den utelates. Typisk vil du utelate typen
for lokale variabler. Om typen er med kommer den etter variabel navnet (som for funksjonsargument)
Variabler kan også forekomme på top level (i en fil), ikke bare i klasser og funksjoner.
c = 3 her er lovlig siden det er første tilordning, men å forsøke å reassigne vil gi en kompileringsfeil.
Et eget nøkkelord 'var' definerer in mutable variabel.
Her ser vi også Streng interpolation. Vi kan referere til til en variabel med $, eller til en
expression med $ og klammer rundt utrykket.



---
## Nullable
```kotlin
val x: String = null // Does not compile

val x: String? = null // Ok

val y: String? = if (Random().nextBoolean()) "foo" else null

println(y.length) // Unsafe, does not compile

println(y!!.length) // Unsafe, compiles
```
Note:
En av tingene jeg liker best i Kotlin er hvordan den håndterer null verdier.
En Nullable og en NonNullable referanse er ulike type, og kan ikke uten videre blandes.
Kompilatoren kan derfor sjekke om du forsøker å tilordne en nullable type til en non nullable, og gi
kompileringsfeil. Du kan tvinge gjennom tilordningen med !! om du er sikker på at den ikke er null,
men dette vil da gi en nullpointer exception ved kjøretid.



## Nullable
```kotlin
val y: String? = if (Random().nextBoolean()) "foo" else null

if (y != null) {
    println(y.length) // safe
}

y.let {               // safe
    println(it)
}

val l = if (y != null) y.length else -1

val m = y?.length ?: -1
```
Note:
Etter en null sjekk kan kompilatoren garantere at verdien ikke er null, og dermed tillate kall som ellers
vill gitt nullpointer. Selv i en branch av en if expression kan kompilatoren sjekke dette.
?. operatoren gir en trygg måte å kalle metode på et potensielt null objekt, og eventuelt gi en alternativ
verdi med ?: operatoren. (Uten den ville m her fått verdien null, og den utledete typen til m ville vært Int? i steden for Int)



---
## Smart Cast
```
if (obj is Person) {
    print(obj.name)
}

if (x is Person && x.age > 20) return

val x = when (something) {
    is String -> something.length
    is Int -> something
    is List<*> -> something.size
    else -> -1
}
```
Note: 
Smart cast er en annen ting hvor kotlin compilatoren kan utlede informasjon om hvilken type en variabel har
basert på typesjekken du gjør, og dermed ungå eksplisit casting (som du må i Java)
F.eks om du sjekker typen i en if expression vil variabelen ha en utledet  type der condition er true.
Dette gjelder til og med i et kombinert boolean uttrykk. 
Implisit cast om condition er true. Dette kombinerer fint med when expression, som er en mer generell variant
av javas switch case. Her vil variabelen kunne behandles som om den har den typen som ble sjekket for på høyre
side av uttrykket.



---
## Classes
```
class Event { }

class Message

class Student {

    private val name: String

    constructor(name: String) {
        this.name = name
    }
}

class Person(val firstName: String) 

class Person2(val firstName: String, val lastName: String, var age: Int)
```
Note:
en minimal klasse trenger ikke en gang en blokk. klasser kan defineres med feld og metoder som i Java.
Ofte defineres konstruktøren innlin.

---
## Data Classes
```
data class User(val userName: String, val password: String)

data class Book(val title: String, val author: String, val year: Int = -1, val sortedUnder: String = author)
```
Note: Klasser er final by default (bruke open keyword)
Flere tema; getters/setters, companion objects, delegation, ++



---
## Lambdas
```

```
Note: