import instaloader
from kafka import KafkaProducer
from datetime import datetime
import subprocess
import json

L = instaloader.Instaloader()

producer = KafkaProducer(bootstrap_servers=['localhost:9092'],
value_serializer=lambda x: json.dumps(x).encode('utf-8'))

posts = 0

for post in L.get_hashtag_posts("ipl"):	
	if posts>= 50:
		break
	producer.send('twitter', value = { 'caption': post.caption })
	producer.flush()