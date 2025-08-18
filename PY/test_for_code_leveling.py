import unittest
from code_leveling import tuple_appending

class TestTupleAppending(unittest.TestCase):
	
	def test_to_apend_number_to_tuple(self):
		first_tuple = (2, 3, 5, 6)
		number = 7
		self.assertEqual(tuple_appending(first_tuple, number), (2, 3, 5, 6, 7))
	
	def test_to_add_number_to_an_empty_tuple(self):
		first_tuple = ()
		number = 7
		self.assertEqual(tuple_appending(first_tuple, number), (7,))

	def test_to_add_number_to_tuple_of_one_value(self):
		first_tuple = (20,)
		number = 7
		self.assertEqual(tuple_appending(first_tuple, number), (20, 7))

	def test_to_add_negative_number_to_tuple(self):
		first_tuple = (2, 3, 5, 6)
		number = -7
		self.assertEqual(tuple_appending(first_tuple, number), (2, 3, 5, 6, -7))

	def test_to_raise_value_error_if_appended_tuple_is_not_number(self):
		first_tuple = (2, 3, 5, 6)
		with self.assertRaises(ValueError):
			tuple_appending(first_tuple, 'v')