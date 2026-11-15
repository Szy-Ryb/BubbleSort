import java.math.BigDecimal; // klasa do dokładnych liczb dziesiętnych (bez utraty precyzji)
import java.util.Scanner;

public class BubbleSort { // główna klasa programu w Javie

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // utworzenie obiektu scanner do inputu z klawiatury

        System.out.println("Copyright Szymon Rybikowski"); // copyright

        System.out.print("Podaj liczby dziesiętne oddzielone spacją (np. 5.75 -0.1 1e-5 3): "); // prośba o wpisanie liczb

        String[] wejscie = scanner.nextLine().trim().split("\\s+"); // pobranie całej linii i podział na pojedyncze liczby (jako tekst)

        {
            try {
                BigDecimal[] liczby = new BigDecimal[wejscie.length]; // tablica na dokładne liczby dziesiętne

                for (int i = 0; i < wejscie.length; i++) { // przejście po wszystkich wpisanych wyrazach
                    liczby[i] = new BigDecimal(wejscie[i].replace(',', '.')); // przecinek zamieniony na kropkę, tekst zamieniony na BigDecimal
                }

                int n = liczby.length; // liczba elementów w tablicy

                for (int i = 0; i < n - 1; i++) { // zewnętrzna pętla: każdy obieg ustawia jeden największy element na końcu

                    boolean zamiana = false; // flaga: czy w tym obiegu była jakakolwiek zamiana

                    for (int j = 0; j < n - 1 - i; j++) { // wewnętrzna pętla: porównanie sąsiednich elementów

                        if (liczby[j].compareTo(liczby[j + 1]) > 0) { // jeśli lewy element jest większy od prawego

                            BigDecimal pomocnicza = liczby[j]; // zapamiętanie lewego elementu
                            liczby[j] = liczby[j + 1]; // wstawienie prawego elementu na miejsce lewego
                            liczby[j + 1] = pomocnicza; // wstawienie zapamiętanego elementu na miejsce prawego

                            zamiana = true; // zapamiętanie, że zamiana miała miejsce
                        }
                    }

                    if (!zamiana) { // jeśli w całym obiegu nie było zamiany, tablica jest już posortowana
                        break; // przerwanie pętli
                    }
                }

                System.out.print("Posortowane rosnąco: "); // nagłówek wyniku (bez przejścia do nowej linii)

                for (int i = 0; i < n; i++) { // przejście po posortowanej tablicy
                    System.out.print(liczby[i].toPlainString()); // wyświetlenie liczby (bez notacji naukowej)
                    if (i < n - 1) { // jeśli to nie ostatnia liczba
                        System.out.print(" "); // spacja między liczbami
                    }
                }

                System.out.println(); // przejście do nowej linii po wypisaniu wszystkich liczb

            } catch (NumberFormatException e) { // wyjątek gdy input to inne znaki niż liczby
                System.out.println("Błąd!! To nie jest poprawna liczba!");
            }
        }

        scanner.close(); // zamknięcie skanera w celu zwolnienia zasobów systemowych
    }
} // Copyright Szymon Rybikowski