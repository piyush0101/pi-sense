from bottle import route, run
import os
import RPi.GPIO as GPIO

GPIO.setmode(GPIO.BCM)

@route('/hello')
def hello():
    return "hello world"

def readadc(adcnum, clockpin, mosipin, misopin, cspin):
	if ((adcnum > 7) or (adcnum < 0)):
		return -1
	GPIO.output(cspin, True)

	GPIO.output(clockpin, False)
	GPIO.output(cspin, False)

	commandout = adcnum
	commandout |= 0x18
	commandout << =3

	for i in range(5):
		if (commandout & 0x80):
			GPIO.output(mosipin, True)
		else:
			GPIO.output(mosipin, False)
		commandout <<= 1
		GPIO.output(clockpin, True)
		GPIO.output(clockpin, False)
	adcout = 0

	for i in range(12):
		GPIO.output(clockpin, True)
		GPIO.output(clockpin, False)
		adcout <<= 1
		if (GPIO.input(misopin)):
			adcout |= 0x1
	GPIO.output(cspin, True)
	adcout /= 2
	return adcout

SPICLK = 18
SPIMISO = 23
SPIMOSI = 24
SPICS = 25

GPIO.setup(SPIMOSI, GPIO.OUT)
GPIO.setup(SPIMISO, GPIO.IN)
GPIO.setup(SPICLK, GPIO.OUT)
GPIO.setup(SPICS, GPIO.OUT)


run(host='localhost', port=8080, debug=True)
