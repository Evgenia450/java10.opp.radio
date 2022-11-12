package ru.netology.radio;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @ParameterizedTest
    @CsvSource({
            "Диапозон ниже 0,-1,0",
            "Нижняя граница,0,0",
            "Средние значения,4,4",
            "Верхняя граница,9,9",
            "Диапозон больше 9,10,0",
    })
    public void testSetCurrentStation(String testName, int station, int expected) {
        Radio rad = new Radio();
        rad.setCurrentStation(station);

        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "Нижняя граница,0,1",
            "Средние значения,4,5",
            "Верхняя граница,9,0",
    })
    public void testNext(String testName, int station, int expected) {
        Radio rad = new Radio();
        rad.setCurrentStation(station);
        rad.next();

        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "Нижняя граница,0,9",
            "Средние значения,4,3",
            "Верхняя граница,9,8",
    })
    public void testPrev(String testName, int station, int expected) {
        Radio rad = new Radio();
        rad.setCurrentStation(station);
        rad.prev();

        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "Диапозон ниже 0,-1,0",
            "Нижняя граница,0,0",
            "Средние значения,5,5",
            "Верхняя граница,10,10",
            "Диапозон больше 9,11,0",
    })
    public void testSetCurrentVolume(String testName, int volume, int expected) {
        Radio rad = new Radio();
        rad.setCurrentVolume(volume);

        int actual = rad.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "Нижняя граница,0,1",
            "Средние значения,5,6",
            "Верхняя граница,10,10",
    })
    public void testIncreaseVolume(String testName, int volume, int expected) {
        Radio rad = new Radio();
        rad.setCurrentVolume(volume);
        rad.increaseVolume();

        int actual = rad.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "Нижняя граница,0,0",
            "Средние значения,5,4",
            "Верхняя граница,10,9",
    })
    public void testDecreaseVolume(String testName, int volume, int expected) {
        Radio rad = new Radio();
        rad.setCurrentVolume(volume);
        rad.decreaseVolume();

        int actual = rad.getCurrentVolume();

        assertEquals(expected, actual);
    }
}

