/**
 *  KuKu Harmony_Soundbar
 *
 *  Copyright 2017 turlvo
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */
metadata {
	definition (name: "KuKu Harmony_Soundbar", namespace: "ccasper38", author: "berkeros") {
		capability "Actuator"
		capability "Configuration"
		capability "Health Check"
		capability "Refresh"
		capability "Sensor"
		capability "Switch"

		command "power"
		command "inputanalog"
		command "inputbddvd"
		command "inputbluetooth"
        command "inputcoaxial"
		command "inputtv"
		command "volup"
		command "voldown"
		command "mute"
		command "subwoofup"
		command "subwoofdown"
		command "audiodelay"
		command "bluetoothstanby"
		command "chlevel"
		command "clearvoice"
		command "dspgame"
		command "dspmovie"
		command "dspmusic"
		command "dspsports"
		command "dsptv"
		command "stereo"
		command "univolume"
        
        command "virtualOn"
        command "virtualOff"
	}

	tiles (scale: 2){      
		multiAttributeTile(name:"switch", type: "generic", width: 6, height: 8, canChangeIcon: true){
			tileAttribute ("device.switch", key: "PRIMARY_CONTROL") {
                attributeState "off", label:'${name}', action:"switch.on", backgroundColor:"#ffffff", icon: "st.switches.switch.off", nextState:"turningOn"
				attributeState "on", label:'${name}', action:"switch.off", backgroundColor:"#79b821", icon: "st.switches.switch.on", nextState:"turningOff"				
				attributeState "turningOn", label:'${name}', action:"switch.off", backgroundColor:"#79b821", icon: "st.switches.switch.off", nextState:"turningOff"
				attributeState "turningOff", label:'${name}', action:"switch.on", backgroundColor:"#ffffff", icon: "st.switches.switch.on", nextState:"turningOn"
			}
        }

        valueTile("power", "device.power", width: 2, height: 1, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "yes", label: "POWER", action: "power"
            state "no", label: "unavail", action: ""
        }
        valueTile("inputanalog", "device.inputanalog", width: 2, height: 1, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "yes", label: "Input Analog", action: "inputanalog"
            state "no", label: "unavail", action: ""
        }
        valueTile("inputbddvd", "device.inputbddvd", width: 2, height: 1, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "yes", label: "Input BD'/'DVD", action: "inputbddvd"
            state "no", label: "unavail", action: ""
        }
        valueTile("inputbluetooth", "device.inputbluetooth", width: 2, height: 1, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "yes", label: "Input Bluetooth", action: "inputbluetooth"
            state "no", label: "unavail", action: ""
        }
        valueTile("inputcoaxial", "device.inputcoaxial", width: 2, height: 1, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "yes", label: "Input Coaxial", action: "inputcoaxial"
            state "no", label: "unavail", action: ""
        }
        valueTile("inputtv", "device.inputtv", width: 2, height: 1, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "yes", label: "Input Tv", action: "inputtv"
            state "no", label: "unavail", action: ""
        }
        valueTile("volup", "device.volup", width: 2, height: 1, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "yes", label: "+\nVolume Up", action: "volup"
            state "no", label: "unavail", action: ""
        }
        valueTile("voldown", "device.voldown", width: 2, height: 1, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "yes", label: "Volume Down\n-", action: "voldown"
            state "no", label: "unavail", action: ""
        }
        valueTile("mute", "device.mute", width: 2, height: 1, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "yes", label: "Mute", action: "mute"
            state "no", label: "unavail", action: ""
        }
        valueTile("subwoofup", "device.subwoofup", width: 2, height: 1, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "yes", label: "∧\nSubwoofer Up", action: "subwoofup"
            state "no", label: "unavail", action: ""
        }
        valueTile("subwoofdown", "device.subwoofdown", width: 2, height: 1, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "yes", label: "Subwoofer Down\n∨", action: "subwoofdown"
            state "no", label: "unavail", action: ""
        }
        valueTile("audiodelay", "device.audiodelay", width: 2, height: 1, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "yes", label: "Audio Delay", action: "audiodelay"
            state "no", label: "unavail", action: ""
        }
        valueTile("bluetoothstanby", "device.bluetoothstanby", width: 2, height: 1, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "yes", label: "Bluetooth Stanby", action: "bluetoothstanby"
            state "no", label: "unavail", action: ""
        }
        valueTile("chlevel", "device.chlevel", width: 2, height: 1, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "yes", label: "Ch Level", action: "chlevel"
            state "no", label: "unavail", action: ""
        }
        valueTile("clearvoice", "device.clearvoice", width: 2, height: 1, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "yes", label: "Clear Voice", action: "clearvoice"
            state "no", label: "unavail", action: ""
        }
        valueTile("dspgame", "device.dspgame", width: 2, height: 1, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "yes", label: "Dsp Game", action: "dspgame"
            state "no", label: "unavail", action: ""
        }
        valueTile("dspmovie", "device.dspmovie", width: 2, height: 1, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "yes", label: "Dsp Movie", action: "dspmovie"
            state "no", label: "unavail", action: ""
        }
        valueTile("dspmusic", "device.dspmusic", width: 2, height: 1, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "yes", label: "Dsp Music", action: "dspmusic"
            state "no", label: "unavail", action: ""
        }
        valueTile("dspsports", "device.dspsports", width: 2, height: 1, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "yes", label: "Dsp Sports", action: "dspsports"
            state "no", label: "unavail", action: ""
        }
        valueTile("dsptv", "device.dsptv", width: 2, height: 1, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "yes", label: "Dsp Tv", action: "dsptv"
            state "no", label: "unavail", action: ""
        }
        valueTile("stereo", "device.stereo", width: 2, height: 1, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "yes", label: "Stereo", action: "stereo"
            state "no", label: "unavail", action: ""
        }
        valueTile("univolume", "device.univolume", width: 2, height: 1, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "yes", label: "Uni Volume", action: "univolume"
            state "no", label: "unavail", action: ""
        }
        
	main(["switch"])
	details(["power", "volup", "subwoofup",
            "mute", "voldown", "subwoofdown",
            "inputanalog", "inputbddvd", "inputbluetooth",
            "inputcoaxial", "inputtv", "bluetoothstanby",
            "chlevel", "clearvoice", "univolume",
            "dspgame", "dspmovie", "dspmusic",
            "dspsports", "dsptv", "stereo",
            "audiodelay"])    
	}
}

def installed() {
	log.debug "installed()"
	//configure()
}

// parse events into attributes
def parse(String description) {
	log.debug "Parsing '${description}'"
}

def power() {
    log.debug "child power()"
    log.debug "power>> ${device.currentState("switch")?.value}"
    def currentState = device.currentState("switch")?.value

    if (currentState == "on") {
		off()
    } else {
        on()
    }
}

def inputanalog() {
	log.debug "Executing 'inputanalog'"
    parent.command(this, "inputanalog")
}

def inputbddvd() {
	log.debug "Executing 'inputbddvd'"
    parent.command(this, "inputbddvd")
}

def inputbluetooth() {
	log.debug "Executing 'inputbluetooth'"
    parent.command(this, "inputbluetooth")
}

def inputcoaxial() {
	log.debug "Executing 'inputcoaxial'"
    parent.command(this, "inputcoaxial")
}


def inputtv() {
	log.debug "Executing 'inputtv'"
    parent.command(this, "inputtv")
}

def volup() {
	log.debug "Executing 'volup'"
    parent.command(this, "volup")
}

def voldown() {
	log.debug "Executing 'voldown'"
    parent.command(this, "voldown")
}

def mute() {
	log.debug "Executing 'mute'"
    parent.command(this, "mute")
}

def subwoofup() {
	log.debug "Executing 'subwoofup'"
    parent.command(this, "subwoofup")
}

def subwoofdown() {
	log.debug "Executing 'subwoofdown'"
    parent.command(this, "subwoofdown")
}

def audiodelay() {
	log.debug "Executing 'audiodelay'"
    parent.command(this, "audiodelay")
}

def bluetoothstanby() {
	log.debug "Executing 'bluetoothstanby'"
    parent.command(this, "bluetoothstanby")
}

def chlevel() {
	log.debug "Executing 'chlevel'"
    parent.command(this, "chlevel")
}

def clearvoice() {
	log.debug "Executing 'clearvoice'"
    parent.command(this, "clearvoice")
}

def dspgame() {
	log.debug "Executing 'dspgame'"
    parent.command(this, "dspgame")
}

def dspmovie() {
	log.debug "Executing 'dspmovie'"
    parent.command(this, "dspmovie")
}

def dspmusic() {
	log.debug "Executing 'dspmusic'"
    parent.command(this, "dspmusic")
}

def dspsports() {
	log.debug "Executing 'dspsports'"
    parent.command(this, "dspsports")
}

def dsptv() {
	log.debug "Executing 'dsptv'"
    parent.command(this, "dsptv")
}

def stereo() {
	log.debug "Executing 'stereo'"
    parent.command(this, "stereo")
}

def univolume() {
	log.debug "Executing 'univolume'"
    parent.command(this, "univolume")
}

def on() {
	log.debug "child on()"
	parent.command(this, "power-on")
    sendEvent(name: "switch", value: "on")
}

def off() {
	log.debug "child off"
	parent.command(this, "power-off")
    sendEvent(name: "switch", value: "off")
}

def virtualOn() {
	log.debug "child on()"	
    sendEvent(name: "switch", value: "on")
}

def virtualOff() {
	log.debug "child off"	
    sendEvent(name: "switch", value: "off")
}

def generateEvent(Map results) {
    results.each { name, value ->
		log.debug "generateEvent>> name: $name, value: $value"
        def currentState = device.currentValue("switch")
		log.debug "generateEvent>> currentState: $currentState"
        if (currentState != value) {
        	log.debug "generateEvent>> changed to $value"
        	sendEvent(name: "switch", value: value)
        } else {
        	log.debug "generateEvent>> not change"
        }
    }
    return null
}

def poll() {
	log.debug "poll()"
}

def parseEventData(Map results) {
    results.each { name, value ->
        //Parse events and optionally create SmartThings events
    }
}