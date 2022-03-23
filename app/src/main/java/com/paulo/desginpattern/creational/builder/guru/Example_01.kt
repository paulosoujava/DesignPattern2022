package com.paulo.desginpattern.creational.builder.guru


/**
 * Builder interface defines all possible ways to configure a product.
 */
interface Builder {
    fun setCarType(type: CarType?)
    fun setSeats(seats: Int)
    fun setEngine(engine: Engine?)
    fun setTransmission(transmission: Transmission?)
    fun setTripComputer(tripComputer: TripComputer?)
    fun setGPSNavigator(gpsNavigator: GPSNavigator?)
}

/**
 * Concrete builders implement steps defined in the common interface.
 */
class CarBuilder : Builder {
    private var type: CarType? = null
    private var seats = 0
    private var engine: Engine? = null
    private var transmission: Transmission? = null
    private var tripComputer: TripComputer? = null
    private var gpsNavigator: GPSNavigator? = null
    override fun setCarType(type: CarType?) {
        this.type = type
    }

    override fun setSeats(seats: Int) {
        this.seats = seats
    }

    override fun setEngine(engine: Engine?) {
        this.engine = engine
    }

    override fun setTransmission(transmission: Transmission?) {
        this.transmission = transmission
    }

    override fun setTripComputer(tripComputer: TripComputer?) {
        this.tripComputer = tripComputer
    }

    override fun setGPSNavigator(gpsNavigator: GPSNavigator?) {
        this.gpsNavigator = gpsNavigator
    }

    val result: Car?
        get() = type?.let { Car(it, seats, engine, transmission, tripComputer, gpsNavigator) }
}

/**
 * Unlike other creational patterns, Builder can construct unrelated products,
 * which don't have the common interface.
 *
 * In this case we build a user manual for a car, using the same steps as we
 * built a car. This allows to produce manuals for specific car models,
 * configured with different features.
 */
class CarManualBuilder : Builder {
    private var type: CarType? = null
    private var seats = 0
    private var engine: Engine? = null
    private var transmission: Transmission? = null
    private var tripComputer: TripComputer? = null
    private var gpsNavigator: GPSNavigator? = null
    override fun setCarType(type: CarType?) {
        this.type = type
    }

    override fun setSeats(seats: Int) {
        this.seats = seats
    }

    override fun setEngine(engine: Engine?) {
        this.engine = engine
    }

    override fun setTransmission(transmission: Transmission?) {
        this.transmission = transmission
    }

    override fun setTripComputer(tripComputer: TripComputer?) {
        this.tripComputer = tripComputer
    }

    override fun setGPSNavigator(gpsNavigator: GPSNavigator?) {
        this.gpsNavigator = gpsNavigator
    }

    val result: Manual
        get() = Manual(type, seats, engine, transmission, tripComputer, gpsNavigator)
}

/**
 * Car is a product class.
 */
class Car(
    carType: CarType, seats: Int, engine: Engine?, transmission: Transmission?,
    tripComputer: TripComputer?, gpsNavigator: GPSNavigator?
) {
    private val carType: CarType = carType
    val seats: Int = seats
    private val engine: Engine = TODO()
    private val transmission: Transmission = TODO()
    private val tripComputer: TripComputer?
    private val gpsNavigator: GPSNavigator
    var fuel = 0.0

    fun getCarType(): CarType {
        return carType
    }

    fun getEngine(): Engine {
        return engine
    }

    fun getTransmission(): Transmission {
        return transmission
    }

    fun getTripComputer(): TripComputer? {
        return tripComputer
    }

    fun getGpsNavigator(): GPSNavigator {
        return gpsNavigator
    }

    init {
        if (engine != null) {
            this.engine = engine
        }
        if (transmission != null) {
            this.transmission = transmission
        }
        this.tripComputer = tripComputer
        if (this.tripComputer != null) {
            this.tripComputer.setCar(this)
        }
        if (gpsNavigator != null) {
            this.gpsNavigator = gpsNavigator
        }
    }
}
enum class CarType {
    CITY_CAR, SPORTS_CAR, SUV
}

/**
 * Car manual is another product. Note that it does not have the same ancestor
 * as a Car. They are not related.
 */
class Manual(
    carType: CarType?, seats: Int, engine: Engine?, transmission: Transmission?,
    tripComputer: TripComputer?, gpsNavigator: GPSNavigator?
) {
    private val carType: CarType
    private val seats: Int
    private val engine: Engine
    private val transmission: Transmission
    private val tripComputer: TripComputer?
    private val gpsNavigator: GPSNavigator?
    fun print(): String {
        var info = ""
        info += "Type of car: $carType\n"
        info += "Count of seats: $seats\n"
        info += """
               Engine: volume - ${
            engine.volume.toString()
        }; mileage - ${engine.mileage.toString()}
               
               """.trimIndent()
        info += "Transmission: $transmission\n"
        info += if (tripComputer != null) {
            """
     Trip Computer: Functional
     
     """.trimIndent()
        } else {
            """
     Trip Computer: N/A
     
     """.trimIndent()
        }
        info += if (gpsNavigator != null) {
            """
     GPS Navigator: Functional
     
     """.trimIndent()
        } else {
            """
     GPS Navigator: N/A
     
     """.trimIndent()
        }
        return info
    }

    init {
        this.carType = carType!!
        this.seats = seats
        this.engine = engine!!
        this.transmission = transmission!!
        this.tripComputer = tripComputer
        this.gpsNavigator = gpsNavigator
    }
}

/**
 * Just another feature of a car.
 */
class Engine(val volume: Double, var mileage: Int) {
    var isStarted = false
        private set

    fun on() {
        isStarted = true
    }

    fun off() {
        isStarted = false
    }

    fun go(mileage: Int) {
        if (isStarted) {
            this.mileage += mileage
        } else {
            System.err.println("Cannot go(), you must start engine first!")
        }
    }

}

/**
 * Just another feature of a car.
 */
class GPSNavigator {
    var route: String
        private set

    constructor() {
        route = "221b, Baker Street, London  to Scotland Yard, 8-10 Broadway, London"
    }

    constructor(manualRoute: String) {
        route = manualRoute
    }
}

/**
 * Just another feature of a car.
 */
enum class Transmission {
    SINGLE_SPEED, MANUAL, AUTOMATIC, SEMI_AUTOMATIC
}

/**
 * Just another feature of a car.
 */
class TripComputer {
    private var car: com.paulo.desginpattern.creational.builder.guru.Car? = null
    fun setCar(car: com.paulo.desginpattern.creational.builder.guru.Car?) {
        this.car = car
    }

    fun showFuelLevel() {
        println("Fuel level: " + car!!.fuel)
    }

    fun showStatus() {
        if (car!!.getEngine().isStarted) {
            println("Car is started")
        } else {
            println("Car isn't started")
        }
    }
}

/**
 * Director defines the order of building steps. It works with a builder object
 * through common Builder interface. Therefore it may not know what product is
 * being built.
 */
class Director {
    fun constructSportsCar(builder: Builder) {
        builder.setCarType(CarType.SPORTS_CAR)
        builder.setSeats(2)
        builder.setEngine(Engine(3.0, 0))
        builder.setTransmission(Transmission.SEMI_AUTOMATIC)
        builder.setTripComputer(TripComputer())
        builder.setGPSNavigator(GPSNavigator())
    }

    fun constructCityCar(builder: Builder) {
        builder.setCarType(CarType.CITY_CAR)
        builder.setSeats(2)
        builder.setEngine(Engine(1.2, 0))
        builder.setTransmission(Transmission.AUTOMATIC)
        builder.setTripComputer(TripComputer())
        builder.setGPSNavigator(GPSNavigator())
    }

    fun constructSUV(builder: Builder) {
        builder.setCarType(CarType.SUV)
        builder.setSeats(4)
        builder.setEngine(Engine(2.5, 0))
        builder.setTransmission(Transmission.MANUAL)
        builder.setGPSNavigator(GPSNavigator())
    }
}

/**
 * Demo class. Everything comes together here.
 */
object Demo {
    @JvmStatic
    fun main(args: Array<String>) {
        val director = Director()

        // Director gets the concrete builder object from the client
        // (application code). That's because application knows better which
        // builder to use to get a specific product.
        val builder = CarBuilder()
        director.constructSportsCar(builder)

        // The final product is often retrieved from a builder object, since
        // Director is not aware and not dependent on concrete builders and
        // products.
        val car: Car = builder.result!!
        println(
            """
                Car built:
                ${car.getCarType()}
                """.trimIndent()
        )
        val manualBuilder = CarManualBuilder()

        // Director may know several building recipes.
        director.constructSportsCar(manualBuilder)
        val carManual: Manual = manualBuilder.result
        println(
            """
                
                Car manual built:
                ${carManual.print()}
                """.trimIndent()
        )
    }
}