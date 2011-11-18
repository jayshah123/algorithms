#!/usr/bin/python2.6

import sys

def hello(name):
	name = name + '!!!!!!!!!!'
	print 'hello' + name + 'saf'

def main():
	hello(sys.argv[1])


if __name__ == '__main__':
	main()

