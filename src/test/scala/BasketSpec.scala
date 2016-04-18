import org.scalatest.FunSpec

class BasketSpec extends FunSpec {

  describe("A Basket") {

    describe("when empty") {
      it("should have return a total of £0.00") {
        val basket = new Basket()
        val total = basket.checkout()
        assert(total == 0.00)
      }
    }

    describe("when with 3 apples and 1 orange") {
      it("should amount to a total of £2.05") {
        val basket = new Basket()
        val total = basket.checkout(List("Apple", "Apple", "Orange", "Apple"))
        assert(total == 2.05)
      }
    }

    describe("when with 4 apples and 4 oranges") {
      it("should amount to a total of £3.40") {
        val basket = new Basket()
        val total = basket.checkout(List("Apple", "Orange", "Apple", "Orange", "Apple", "Apple", "Orange", "Orange"))
        assert(total == 3.40)
      }
    }

    describe("when with offers of buy 1 apple and get 1 free and buy 3 oranges for the price of 2") {

      describe("when there's 2 apples") {
        it("should have a discount calculation of £0.60") {
          val basket = new Basket()
          val products = List("Apple", "Apple")
          val discount = basket.offer(products, basket.apple, basket.applePrice, 2, 1)
          assert(discount == 0.60)
        }
      }

      describe("when there's 3 oranges") {
        it("should have a discount calculation of £0.25") {
          val basket = new Basket()
          val products = List("Orange", "Orange", "Orange")
          val discount = basket.offer(products, basket.orange, basket.orangePrice, 3, 2)
          assert(discount == 0.25)
        }
      }

      describe("when basket has 2 apples") {
        it("should amount to a total of £0.60") {
          val basket = new Basket()
          val products = List("Apple", "Apple")
          val discounts = List(basket.offer(products, basket.apple, basket.applePrice, 2, 1),
            basket.offer(products, basket.orange, basket.orangePrice, 3, 2))
          val total = basket.checkout(products, discounts)
          assert(total == 0.60)
        }
      }

      describe("when basket has 3 oranges") {
        it("should amount to a total of £0.50") {
          val basket = new Basket()
          val products = List("Orange", "Orange", "Orange")
          val discounts = List(basket.offer(products, basket.apple, basket.applePrice, 2, 1),
            basket.offer(products, basket.orange, basket.orangePrice, 3, 2))
          val total = basket.checkout(products, discounts)
          assert(total == 0.50)
        }
      }

      describe("when basket has 3 apples and 1 orange") {
        it("should amount to a total of £1.45") {
          val basket = new Basket()
          val products = List("Apple", "Apple", "Orange", "Apple")
          val discounts = List(basket.offer(products, basket.apple, basket.applePrice, 2, 1),
            basket.offer(products, basket.orange, basket.orangePrice, 3, 2))
          val total = basket.checkout(products, discounts)
          assert(total == 1.45)
        }
      }

      describe("when basket has 4 apples and 4 oranges") {
        it("should amount to a total of £1.95") {
          val basket = new Basket()
          val products = List("Apple", "Orange", "Apple", "Orange", "Apple", "Apple", "Orange", "Orange")
          val discounts = List(basket.offer(products, basket.apple, basket.applePrice, 2, 1),
            basket.offer(products, basket.orange, basket.orangePrice, 3, 2))
          val total = basket.checkout(products, discounts)
          assert(total == 1.95)
        }
      }

    }
  }
}