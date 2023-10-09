import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class BazaTest {
    IPolaczenie[] connections = new IPolaczenie[4]; // Tworzenie tablicy przechowującej połączenia
    @Test
    void IsOneInstanceOfBase(){

        for(int i=0;i< connections.length;i++){
            connections[i]=Baza.getPolaczenie();    // Pobranie z bazy 4 połączeń
        }

        char letter = 'A';
        connections[0].set(0, letter);  // Ustawienie za pomoca pierwszego połączenia litery A w tablicy char w Bazie

        // Sprawdzenie czy wszystkie połączenia pobiorą z bazy literę A
        // Jeśli tak to każde połączenie odnosi się do tego samego obiektu Bazy (w programie istnieje tylko jedna Baza)
        assertAll(
                ()->assertEquals(connections[0].get(0),letter),
                ()->assertEquals(connections[1].get(0),letter),
                ()->assertEquals(connections[2].get(0),letter),
                ()->assertEquals(connections[3].get(0),letter)
        );
    }

    @Test
    void IsConnectionsObjectsAreShared(){
        // Połączenia są udostępniane naprzemienie - 0,1,2,0,1,2 itd
        // Jeśli pierwszy i ostatni obiekt Połączenia z tablicy Połączeń są sobie równe to są to te same obiekty
        assertEquals(connections[0], connections[3]);
    }
}
