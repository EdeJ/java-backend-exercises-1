package nl.novi.uitleg.week2;

import nl.novi.uitleg.week2.ondersteunend.People;
import nl.novi.uitleg.week2.ondersteunend.PhoneNumber;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class UitlegNames {
    /**
     * Hoe moet je klasse, methodes en variabele noemen?
     */

    /*
    Gebruik intentie onthullende namen, bekijk onderstaand verschil:
     */

    private int d;
    private int elapsedTimeInDays;
    private int days; // The elapsed time

    /*
    Zorg ervoor dat er geen desinformatie in je code sluipt
    Gebruik bijvoorbeeld geen afkortingen die ook iets anders zouden kunnen beteken.


    Geef een klasse/variabele geen naam met List als er dingen in gegroepeerd worden, zonder List<>.
    (Het is uberhaupt niet heel handig om de datatype in de naam te doen).

    In het geval van verzameling mensen, zou je het volgende kunnen kiezen:
     */

    private Map<Integer, People> peopleList; //Dit zien we dus liever niet
    private List<People> groupOfPeople;
    private List<People> peopleGroup;
    private Map<Integer, People> bunchOfPeople;
    private ArrayList<String> voetbalclubs = new ArrayList<>();


    /**
     * Zorg ervoor dat namen van klasse, methodes en variabelen goed genoeg van elkaar verschillen.
     * Hoe weet je bijvoorbeeld hier welke methode je moet gebruiken op basis van de naam:
     */

    public void voorbeeld() {
        People people = new People();

        //Welke van de onderstaande methodes zou je uit de People klasse gebruiken om zijn account info op te halen?
        //Dat kun je niet bepalen op basis van de methode naam
        people.getAccount();
        people.getAccounts();
        people.getAccountInfo();
    }

    /**
     * Zorg voor uitspreekbare namen. We zijn mensen en we zijn heel goed in het (hardop) lezen van woorden.
     */
    class DataRcrd102 {
        private Date genymdhms;
    }

    class Customer {
        private Date generationTimestamp;
    }

    /**
     * Zorg voor namen waarop gezocht kan worden. Noem variabelen geen i, e of a. Probeer maar eens op een heel project
     * door te zoeken op de letter i, e of a. Daar krijg je te veel resultaten voor terug.
     *
     * Dit hangt ook samen met Mental Mapping. Wanneer variabele de naam a, b of c hebt, kost het meer moeite om te
     * onthouden wat de variabele eigenlijk inhoudt.
     */

    /**
     * Voorkom het gebruik van datatype in namen. Dit is NIET nodig in java.
     */
    private PhoneNumber phoneString;

    /**
     * Klasnamen
     *
     * Klasnamen moeten zelfstandige naamwoorden zijn. Voorkom het gebruik van woorden die meerdere betekenissen
     * kunnen hebben, zoals: Manager, Processor, Data
     */

    /**
     * Methode-namen
     * Gebruik werkwoorden voor methode namen (eventueel met zelfstandig naamwoord)
     * Bijvoorbeeld:
     *  - processPayment();
     *  - deletePage();
     *  - save();
     *
     *  Verder heeft java get, set en is als prefixen die geaccepteerd worden.
     *  isMale();
     *  getName();
     *  setName();
     */

    /**
     * Wees niet grappig met je namen. Als je grappig probeert te zijn in je code, worden je variabele namen alleen
     * gesnapt door mensen die op hetzelfde 'niveau' als jij zitten.
     *
     * Wil je een process stoppen, noem het dan geen whack() maar gewoon kill() of killProcess()
     * Wil je dingen van een lijst verwijderen, noem het niet HolyHandGrenade(), maar DeleteItems()
     */

    /**
     * Gebruik een woord per handeling, en houdt jezelf eraan
     * Dus om data op te halen, gebruik een van deze benamen, en niet allemaal door elkaar:
     * fetch()
     * retrieve()
     * read()
     * get()
     *
     *
     * Hierbij moet erop gelet worden dat dingen niet twee dingen mogen gaan beteken, stel je hebt een methode
     * die meerdere dingen aan een lijst kan toevoegen, die heet add()
     *
     * Je gaat nu een methode schrijven, die 1 item aan een lijst toevoegt, ga je die ook add() noemen? append()
     *
     * addAll()
     * add()
     *
     * plusOne()
     */

    /**
     * Je code is geschreven voor andere programmeurs, je mag dus ook Computer-science jargon gebruiken, als dit de code
     * verduidelijkt. Voorkom namen uit het 'domein', die ervoor zorgen dat een (nieuwe) programmeur continue moet
     * checken wat de naam nou betekent.
     */

    /**
     * Als je een meerdere variabele een prefix gaat toevoegen om deze te verduidelijken, kunnen ze vaak beter in een
     * aparte klasse gestopt worden.
     */


}
