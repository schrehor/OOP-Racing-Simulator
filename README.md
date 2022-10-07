# Stanislav Rehor

# Opis projektu:
RaceWay je zavodná simulácia, kde si hráč vytvorí svojho vodiča s ktorým bude počas hry závodiť. Hráč si na začiatku hry vyberie aký závod by chcel spustiť a závodí. Výhrami získava body skúsenosti pre seba a svoje auto. S týmito bodmi sa vylepšuje, aby dosahoval lepších výsledkov. Účel tohto projektu je zábava a odpočinok. Zatiaľ hra nie je interaktívna, takže slúži viac ako simulácia. Postupným pridávaním nových prvkov ako napríklad GUI sa význam hry zmení.

# Spustenie
Hra sa momentalne ovláda cez kód v classe Main. Hra zatial ponúka, len obmedzené možnosti, takže obsluha je veľmi jednoduchá. V classe Main môžete meniť parametre daných funkcií podľa tohto návodu:

## Vytvorenie noveho hraca.
Ako parametre sa udávajú: meno hráča a typ vodiča.
Vodiči môžu byť nasledovní:
1. UniversalDriver - výhody: Môže závodiť s autom aj s motorkou.
                   - nevýhody: Oproti specialistovi získava menší bonus za spieciálny atribút.
2. CarDriver - vyhody: V aute dosahuje lepšie výsledky ako univerzálny vodič.
             - nevyhody: Nemôže závodiť na motorkách.
             
## Priradenie bodov skúseností
Hráč na začiatku dostane 20 bodov, ktoré si može rozdeliť podľa seba. Výhody sú nasledovné:
1. Vehicle Control - Zvyšuje ovládanie v zátačkách.
2. Track Knowledge - Zlepšuje vedemosti o okruhu a tým zlepšuje závodenie.
3. Charisma - Zvyšuje počet bodov skúseností získaných po výhrach.
4. Driving Skill - Všeobecné zlepšenie vodičových schopností.
5. Special Skill - Špeciálna vlastnosť každého vodiča.

## Zmeniť počet protivníkov
V menotôde race() môžete zmeniť poslednú hodnotu, aby ste zmenili počet protivníkov proti ktorým budete závodiť. V momentálnom štádiu to je všetko čo sa dá modifikovať.

# Naplnenie požiadaviek
## Polymorfizmus:
V classách MotoDriver, CarDriver a UniversalDriver používam metódu pickRace, ktorá vykoná iný kód podľa toho, kto ju zavolá
https://github.com/OOP-FIIT/oop-2020-uto-16-c-kovacik-schrehor/blob/7571e2e67ac0d9fa56c0ac025710368989feda32/RaceWay/src/com/stanrehor/driver/MotoDriver.java#L24
https://github.com/OOP-FIIT/oop-2020-uto-16-c-kovacik-schrehor/blob/7571e2e67ac0d9fa56c0ac025710368989feda32/RaceWay/src/com/stanrehor/driver/UniversalDriver.java#L23
https://github.com/OOP-FIIT/oop-2020-uto-16-c-kovacik-schrehor/blob/7571e2e67ac0d9fa56c0ac025710368989feda32/RaceWay/src/com/stanrehor/driver/CarDriver.java#L23

## Zapúzdrenie
V classe DriverBlueprint používam zapúzdrenie na všetky atribúty tejto classy.
https://github.com/OOP-FIIT/oop-2020-uto-16-c-kovacik-schrehor/blob/7571e2e67ac0d9fa56c0ac025710368989feda32/RaceWay/src/com/stanrehor/driver/DriverBlueprint.java#L25

## Dedenie
V classe Driver dedím od classy DriverBlueprint a v classách MotoDriver, CarDriver a UniversalDriver dedím od classy Driver
https://github.com/OOP-FIIT/oop-2020-uto-16-c-kovacik-schrehor/blob/7571e2e67ac0d9fa56c0ac025710368989feda32/RaceWay/src/com/stanrehor/driver/Driver.java#L3

## Agregácia
V classe Player využívam agregaciu v podobe classy Driver
https://github.com/OOP-FIIT/oop-2020-uto-16-c-kovacik-schrehor/blob/7571e2e67ac0d9fa56c0ac025710368989feda32/RaceWay/src/com/stanrehor/player/Player.java#L6

## Oddelenie aplikačnej logiky od používateľskeho rozhrania
Môj program nemá žiadne reálne používateľské rozhranie, ale napriek tomu som oddelil všetku logiku programu od aplikačnej logiky
https://github.com/OOP-FIIT/oop-2020-uto-16-c-kovacik-schrehor/blob/7571e2e67ac0d9fa56c0ac025710368989feda32/RaceWay/src/com/stanrehor/Main.java#L22

# UML
![alt text](https://github.com/OOP-FIIT/oop-2020-uto-16-c-kovacik-schrehor/blob/master/UML.jpg "UML diagram")

# Záver
Tento projekt som vo všetkých predošlých odstavcoch prezentoval v tej podobe ako je daný tu na Gite. Viem, že ma na ňom čaká ešte veľmi veľa práce a sám nie som spokojný s momentalnym výsledkom. Verím, že nabudúce Vás prekvapím.



