# Kotlin
## En introduksjon
#### Morten Nygaard Åsnes

---
## Tema

- Introduksjon
- Historie
- Syntax
- Java
- Scala
- Pros/Cons
- Multiplatform Java/JavaScript/Native
- Interop
Note:
Kotlin seiler opp som en utfordrer til Java, og har plasert seg foran Groovy og Clojure, og tar innpå Scala.
Kotlin har spesielt etablert seg som den største utfordreren til Java på Android platformen. Mye pga at java 
for Android har hengt langt bak standard Java når det kommer til nye features for funksjonell programmering, har Kotlin etablert seg som de facto alternativet 
til Java. Kotlin er nå også ofisielt støttet av google til Android programmering, på linje med Java.
Men også på server utvikling blir Kotlin mer populært. Det er nå offisielt støttet av spring og spring boot, som alternativ til
Java. Kotlin har hatt som mål å være et mer konsist, mindre verbost alternativ til Java, og egner seg spesielt
til å utvikle DSL'er i.



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
Et minimalt Kotlin program. En funksjon i Kotlin trenger ikke 
tilhøre en klasse. Retur type kan unnlates om den er Unit (void). 
Type kommer etter parameter/argument i typesignaturen.
Legg merke til at 'if' er en expression.
Om funksjonen består av en enkelt expression kan den skrives med = uten klammer.
Returtypen kan også unnlates om den kan utledes. Semicolons are optional.



---
## Variabler
### Immutable
```kotlin
val a: Int = 1 
val b = 2
val c: Int  
c = 3
```
### Mutable
```kotlin
var sum: Int = 0 
sum = a + b

var s = "$sum = ${a + b}"
```
Note:
'val' definerer en immutable variabel. Om typen kan utledes kan den utelates.
Variabler kan også forekomme på top level (i en fil), ikke bare i klasser og funksjoner.
Et eget nøkkelord 'var' definerer in mutable variabel.
Streng interpolation. Varaiabler eller expressions.



---
## Nullable
```kotlin
val x: String = null // Does not compile

val x: String? = null // Ok

val y: String? = if (Random().nextBoolean()) "foo" else null

println(y.length) // Unsafe, does not compile

println(y!!.length) // Unsafe, compiles

if (y != null) {
    println(y.length) // safe
}

y.let {               // safe
    println(it)
}

val l = if (y != null) y.length else -1

val m = y?.length ?: -1
```
Note: En Nullable og en NonNullable referanse er ulike type, og kan ikke uten videre blandes.



---
## Smart Cast
```
if (obj is Person) {
    print(obj.name)
}

if (x is Person && x.age > 20) return
```
Note: Implisit cast om condition er true



---
## Classes
```
```
Note: Klasser er final by default (bruke open keyword)
