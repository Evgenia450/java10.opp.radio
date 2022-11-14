package ru.netology.radio;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    Radio rad = new Radio();
    Radio radioСhangeStation = new Radio(30);

    @ParameterizedTest
    @CsvSource({
            "Диапозон ниже 0,-1,0",
            "Нижняя граница,0,0",
            "Средние значения,6,6",
            "Верхняя граница,9,9",
            "Максимальный диапозон,10,0",
    })
    public void testSetCurrentStation(String testName, int station, int expected) {

        rad.setCurrentStation(station);

        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "Диапозон ниже 0,-1,0",
            "Нижняя граница,0,0",
            "Средние значения,15,15",
            "upper bound,29,29",
            "Верхняя граница,30,0",
    })
    public void testSetCurrentStationRadioСhangeStation(String testName, int station, int expected) {
        radioСhangeStation.setCurrentStation(station);

        int actual = radioСhangeStation.getCurrentStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "Нижняя граница,0,1",
            "Средние значения,4,5",
            "Верхняя граница,9,0",
    })
    public void testNext(String testName, int station, int expected) {
        rad.setCurrentStation(station);
        rad.next();

        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "Нижняя граница,0,1",
            "Средние значения,15,16",
            "Верхняя граница,29,0",
    })
    public void testNextRadioСhangeStation(String testName, int station, int expected) {
        radioСhangeStation.setCurrentStation(station);
        radioСhangeStation.next();

        int actual = radioСhangeStation.getCurrentStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "Нижняя граница,0,9",
            "Средние значения,4,3",
            "Верхняя граница,9,8",
    })
    public void testPrev(String testName, int station, int expected) {
        rad.setCurrentStation(station);
        rad.prev();

        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "Нижняя граница,0,29",
            "Средние значения,15,14",
            "Верхняя граница,29,28",
    })
    public void testPrevRadioСhangeStation(String testName, int station, int expected) {
        radioСhangeStation.setCurrentStation(station);
        radioСhangeStation.prev();

        int actual = radioСhangeStation.getCurrentStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "Диапозон ниже 0,-1,15",
            "Нижняя граница,0,0",
            "Средние значения,50,50",
            "Верхняя граница,100,100",
            "Максимальный диапозон,101,15",
    })
    public void testSetCurrentVolume(String testName, int volume, int expected) {
        rad.setCurrentVolume(volume);

        int actual = rad.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "Нижняя граница,0,1",
            "Средние значения,50,51",
            "Верхняя граница,100,100",
    })
    public void testIncreaseVolume(String testName, int volume, int expected) {
        rad.setCurrentVolume(volume);
        rad.increaseVolume();

        int actual = rad.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "Нижняя граница,0,0",
            "Средние значения,50,49",
            "Верхняя граница,100,99",
    })
    public void testDecreaseVolume(String testName, int volume, int expected) {
        rad.setCurrentVolume(volume);
        rad.decreaseVolume();

        int actual = rad.getCurrentVolume();

        assertEquals(expected, actual);
    }
}

