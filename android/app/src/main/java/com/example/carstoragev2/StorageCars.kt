package com.example.carstoragev2

class StorageCars {
    private val storage = HashMap<String, Car>()

    fun addCar(aCar: Car) {
        storage[aCar.name] = aCar
    }

    //fun putCarAsFavorite(aCar :Car)

    fun getCar(title: String): Car? {
        return storage[title]
    }

    fun getAllCars(): ArrayList<Car> {
        return ArrayList(storage.values.sortedBy { it.name })
    }

    fun getTotalNumberOfCars(): Int {
        return storage.size;
    }
    fun clear() {
        storage.clear()
    }
}