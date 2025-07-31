import unittest
import functionSnacks
import math
class testFunctionSnacks1(unittest.TestCase):

	def test_that_divide_or_square_function_raises_error_with_string_value(self):
		self.assertRaises(ValueError, functionSnacks.divide_or_square, "bambi")
	
	def test_divide_or_square_returns_sqrt_when_divisible_by_5(self):
      		  self.assertEqual(functionSnacks.divide_or_square(25), 5)


	def test_divide_or_square_raises_error_validation_when_negative(self):
		self.assertRaises(ValueError, functionSnacks.divide_or_square, (-10))

	def test_divide_or_square_returns_float_when_divisible_by_5(self):
      		  self.assertEqual(functionSnacks.divide_or_square(10), 3.16)

	
	def test_that_divide_or_square_root_returns_modulus_when_not_divisible_by_5(self):
      		  self.assertEqual(functionSnacks.divide_or_square(11), 1)
