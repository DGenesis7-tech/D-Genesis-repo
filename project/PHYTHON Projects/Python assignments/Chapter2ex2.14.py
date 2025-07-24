age = int(input('Enter age: '))
maximum_heart_rate = 220 - age
target_heart_rate1 = (50 / 100) * maximum_heart_rate
target_heart_rate2 = (85 / 100) * maximum_heart_rate
print('maximum heart rate is: ', maximum_heart_rate,'bpm')
print('range of your target heart rates is from ', target_heart_rate1,'bpm ',  'to ',  target_heart_rate2,'bpm')