import java.text.DecimalFormat

class Basket {
  val apple = "apple"
  val applePrice = 0.60
  val orange = "orange"
  val orangePrice = 0.25

  def checkout(products: Seq[String] = List(), discounts: Seq[Double] = List()): Double = {
    val total = products.foldLeft(0.0) ((total, product) => product.toLowerCase match {
      case `apple`  => total + applePrice
      case `orange` => total + orangePrice
      case _      => total
    })

    val discountTotal = (0.0 /: discounts) {_+_}

    // Formatting to 2 decimal places
    "%.2f".format(total - discountTotal).toDouble
  }

  def offer(products: Seq[String], productToDiscount: String, price: Double, howMany: Int, forThePriceOf: Int): Double = {
    val qty = products.count(_.toLowerCase == productToDiscount)
    val discountQty = qty / howMany
    val multi = howMany - forThePriceOf
    discountQty * multi * price
  }
}