package ii_collections

import java.util.logging.Logger

fun example() {

    val result = listOf("abc", "12").flatMap { it.toList() }

    result == listOf('a', 'b', 'c', '1', '2')
}

val Customer.orderedProducts: Set<Product> get() {
    // Return all products this customer has ordered
    return orders.flatMap { it.products.toList() }.toSet()
}

val Shop.allOrderedProducts: Set<Product> get() {
    // Return all products that were ordered by at least one customer
    val toSet = customers.flatMap { it.orderedProducts }.toSet()
    return toSet
}
