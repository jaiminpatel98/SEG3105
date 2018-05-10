import unittest
import MyMath

class MyTestCase(unittest.TestCase):


    def test_DivPass(self):
        number1 = 6
        number2 = 3
        expected = 2
        self.assertEqual(expected, MyMath.div(number1, number2))

    def test_DivFail(self):
        number1 = 6
        number2 = 3
        expected = 3
        self.assertEqual(expected, MyMath.div(number1, number2))

    def test_DivError(self):
        number1 = 6
        number2 = 0
        expected = 2
        self.assertEqual(expected, MyMath.div(number1, number2))

    def test_DivException(self):
        number1 = 6
        number2 = 0
        expected = 2
        try:
            self.assertEqual(expected, MyMath.div(number1, number2))
            self.fail('No exception thrown')
        except ZeroDivisionError:
            pass

if __name__ == '__main__':
    unittest.main()
