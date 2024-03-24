#include <IRremote.h>

IRsend IrSender;

// On the Zero and others we switch explicitly to SerialUSB
#if defined(ARDUINO_ARCH_SAMD)
#define Serial SerialUSB
#endif
//int IR_RECEIVE_PIN = 15;
void setup() 
{

    pinMode(IR_SEND_PIN, OUTPUT);

    Serial.begin(115200);
#if defined(__AVR_ATmega32U4__) || defined(SERIAL_USB) || defined(SERIAL_PORT_USBVIRTUAL)
    delay(2000); // To be able to connect Serial monitor after reset and before first printout
#endif
    // Just to know which program is running on my Arduino
    Serial.println(F("START " __FILE__ " from " __DATE__));
    Serial.print(F("Ready to send IR signals at pin "));
    Serial.println(IR_SEND_PIN);
}

void loop() 
{
  // put your main code here, to run repeatedly:
  
  /*unsigned int SVRawData[67] = {4550,4500, 600,1650, 600,1650, 600,1650, 600,550, 550,550, 600,550, 550,550, 600,550, 550,1700, 550,1700, 550,1700, 550,550, 600,550, 550,550, 600,550, 550,550, 600,1650, 600,1650, 600,1650, 600,550, 550,550, 600,550, 550,550, 600,550, 600,500, 600,550, 600,500, 600,1650, 600,1650, 600,1650, 600,1650, 600,1650, 600}; 
  IrSender.sendRaw(SVRawData, 67, 38);*/
  IrSender.sendNEC(0xECFB92B0, 32);
  unsigned int rawData[41] = {2500,600, 600,600, 1250,600, 1250,600, 650,600, 1250,600, 650,600, 600,650, 600,600, 1250,600, 600,650, 1200,650, 1200,650, 650,600, 1250,600, 600,600, 600,650, 600,650, 1200,650, 1200,600, 1250};  // Protocol=UNKNOWN Data=0xECFB92B0
  IrSender.sendRaw(rawData, 41, 38);
  delay(1000);

  Serial.println("Signal sended\n");

}
