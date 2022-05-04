# Online-Library
An online library made in java.

------Classes------

---Pentru fiecare clasa din enunt am adaugat un camp de tip "static ArrayList<ClassName> allClassName" care
reprezinta fiecare entitate initializata din fisierele .in.
---Deasemenea, exista o metoda, "initClassName", care citeste din fisiere obiectele si le initializeaza in campul
de mai sus.
---Proptietatile/ campurile sunt private, putand fi modificate prin sett-ere si accesate prin get-ere.

---Helpers---

= clasa ajutatoare, pentru a face codul mai usor de urmarit.

-authorToString = obiect de tip Author -> String
-authorsToString = obiecte de tip Author -> String
-calendarToString = obiect de tip Calendar -> String
-publishBookWithoutXml = transforma un obiect de tip Carte intr-un string XML
    nrTabs - numarul de tab-uri pentru a respecta formatul din enunt
    flag - daca sa se adauge la inceput <book> si la sfarsit </book>
-IDTo* = returneaza obiectul cu ID-ul respectiv
-IDToIndex* = returneaza indexul obiectului cu ID-ul respectiv
-Print* = printeaza obiectele dintr-o lista, cate 4 pe linie, separate prin "###"
-PublishingRetailersToIDs = transforma o lista de publishingRetailers intr-o lista de IDs

---FileToList---

= clasa ajutatoare, care transforma informatia dintr-un fisier in lista de obiecte(read*FromFile), sau creaza legaturi
    intre listele de obiecte(assign*To*).

---Administration---

= clasa care are metodele care rezolva cerintele, fiecare metoda are ca parametru un printFlag de tip boolean, daca este
    true se afiseaza ceea ce se cere.

-getBooksForPublishingRetailerID =
    1.prin functia IDToPublishingRetailer gasesc retailer-ul
    2.introduc toate cartile sale intr-o lista
    3.elimin duplicatele folosind un LinkedHashSet

-getLanguagesForPublishingRetailerID =
    1.folosind metoda anterioara, obtin cartile retailer-ului
    2.adaug LanguageID din fiecare carte intr-o lista
    3.elimin duplicatele folosind un LinkedHashSet

-getCountriesForBookID =
    1.folosind PublishingRetailersToIDs transform retailers intr-o lista de IDs
    2.ma plimb prin lista de IDs, retinand cartile retailer-ului
    3.daca h.IDToBook(booksAux, bookID) != null atunci am gasit cartea
    3.adaugam tarile retailer-ului care contine cartea intr-o lista
    4.elimin duplicatele folosind un LinkedHashSet

-getCommonBooksForRetailerIDs
    1.folosing getBooksForPublishingRetailerID obtin cartile celor doi retaileri
    2.folosind retainAll, obtin doar cartile comune

-getAllBooksForRetailerIDs
    1.folosing getBooksForPublishingRetailerID obtin cartile celor doi retaileri
    2.le adaug intr-un HashSet pentru a elimina duplicatele
    3.convertesc in ArrayList
