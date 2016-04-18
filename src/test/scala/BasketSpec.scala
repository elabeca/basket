import org.scalatest.FunSpec

class BasketSpec extends FunSpec {

  describe("A Basket") {

    describe("when empty") {
      it("should have return a total of £0.00") {
        val basket = new Basket()
        val total = basket.checkout(List())
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

  }
}