package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        val i = when {
            year != other.year -> year - other.year
            month != other.month -> month - other.month
            else -> dayOfMonth - other.dayOfMonth
        }
        return i
    }

    operator fun plus(timeInterval: TimeInterval): MyDate {
        return this.addTimeIntervals(timeInterval, 1)
    }

    operator fun plus(timeInterval: RepeatedTimeInterval): MyDate {
        return this.addTimeIntervals(timeInterval.ti, timeInterval.n)
    }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange {
    return DateRange(this, other)
}

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR;

    operator fun times(i :Int):RepeatedTimeInterval {
        return RepeatedTimeInterval(this, i)
    }
}

class RepeatedTimeInterval(val ti: TimeInterval, val n: Int)

class DateRange(val start: MyDate, val endInclusive: MyDate) : Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return DateRangeIterator(start, endInclusive)
    }

    operator fun contains(date: MyDate): Boolean {
        return date >= start && date <= endInclusive
    }
}

class DateRangeIterator(var start: MyDate, private val endInclusive: MyDate) : Iterator<MyDate> {
    override fun hasNext(): Boolean {
        return start <= endInclusive
    }

    override fun next(): MyDate {
        val current = start
        start = start.nextDay()
        return current
    }
}
