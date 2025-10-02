import unittest
from MagicSquare import get_magic_square

class TestMagicSquare(unittest.TestCase):
	def test_get_magic_square_returns_true_if_it_takes_2D_list_as_argument(self):
    		self.assertTrue(get_magic_square([[2, 3, 5], [4, 5, 1]]))
    	
	def test_get_magic_square_returns_true_if_it_takes_2D_list_of_integers_as_arguments(self):
    		self.assertTrue(get_magic_square([[2, 3, 5], [4, 5, 1], [4, 2, 4]]))
	
	def test_get_magic_square_throws_exception_if_arguments_is_not_2D_list_of_integers(self):				
    		self.assertRaises(TypeError, get_magic_square, [['A', 'B', 'C'], ['D', 'E', 'F']])
    		
	def test_length_of_2D_list_equals_length_of_lists_in_2D_list(self):
		self.assertTrue(get_magic_square([[2, 3, 5], [4, 5, 1], [4, 2, 4]]))
    		
	def test_2D_list_of_3_by_3_returns_true_if_its_a_perfect_square(self):
    		self.assertTrue(get_magic_square([[2, 3, 5], [4, 5, 1], [4, 2, 4]]))
    	
	def test_2D_list_of_2_by_2_returns_true_if_its_a_perfect_square(self):
    		self.assertTrue(get_magic_square([[2, 3], [3, 2]]))
	