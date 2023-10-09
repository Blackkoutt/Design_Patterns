// Baza jest singletonem
class Baza {

    private char[] tab = new char[100];
    private Baza() {}  // Prywatny konstruktor
    private static Baza instance = new Baza(); // Wczesna inicjalizacja
    private static Baza getInstance(){  // Publiczna metoda dostępowa
        return instance;
    }

    public static IPolaczenie getPolaczenie() {

        return Polaczenie.getInstance();

    }

    // Połączenie jest Multitonem
    private static class Polaczenie implements IPolaczenie {

        private Baza baza = Baza.getInstance(); // Pobranie obiektu Bazy
        private Polaczenie() {};    // Prywatny konstruktor
        private static Polaczenie[] polaczenia = {  // Wczesna inicjalizacja N obiektów
                new Polaczenie(),
                new Polaczenie(),
                new Polaczenie()
        };
        private static int i = 0;

        public static IPolaczenie getInstance() {   // Publiczna metoda dostępowa, obiekty są udostępniane po kolei
            i = (i+1)% polaczenia.length;
            return polaczenia[i];
        }

        public char get(int indeks) {

            return baza.tab[indeks];

        }

        public void set(int indeks, char c) {

            baza.tab[indeks] = c;

        }

        public int length() {

            return baza.tab.length;

        }

    }

}