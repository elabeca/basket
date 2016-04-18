class Basket {
  def checkout(products: Seq[String]): Double = {
    val total = products.foldLeft(0.0) ((total, product) => product match {
      case "Apple"  => total + 0.60
      case "Orange" => total + 0.25
      case _      => total
    })
    total
  }
}