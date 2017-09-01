/**
 *  ViewHD AV Switch
 *
 *  Copyright 2017 ccasper38
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
	definition (name: "KuKu Harmony_AVSwitch", namespace: "ccasper38", author: "berkeros") {
        capability "Actuator"
		capability "Switch"
		capability "Refresh"
		capability "Sensor"
        capability "Configuration"
        capability "Health Check"

		command "power"
		command "Audio2Ch"
		command "Audio51Ch"
		command "AudioAdv"
		command "AudioArc"
		command "AudioSpdif"
		command "A1"
		command "A2"
		command "A3"
		command "A4"
		command "B1"
		command "B2"
		command "B3"
		command "B4"
        
        command "virtualOn"
        command "virtualOff"
	}



	tiles (scale: 2){multiAttributeTile(name:"switch", type: "generic", width: 6, height: 5, canChangeIcon: true){
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
        valueTile("Audio2Ch", "device.Audio2Ch", width: 2, height: 1, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "yes", label: "Audio\n2Ch", action: "Audio2Ch"
            state "no", label: "unavail", action: ""
        }
        valueTile("Audio51Ch", "device.Audio51Ch", width: 2, height: 1, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "yes", label: "Audio\n5.1Ch", action: "Audio5.1Ch"
            state "no", label: "unavail", action: ""
        }
        valueTile("AudioAdv", "device.AudioAdv", width: 2, height: 1, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "yes", label: "Audio\nAdv", action: "AudioAdv"
            state "no", label: "unavail", action: ""
        }
        valueTile("AudioArc", "device.AudioArc", width: 2, height: 1, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "yes", label: "Audio\nArc", action: "AudioArc"
            state "no", label: "unavail", action: ""
        }
        valueTile("AudioSpdif", "device.AudioSpdif", width: 2, height: 1, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "yes", label: "Audio\nSpdif", action: "AudioSpdif"
            state "no", label: "unavail", action: ""
        }
        valueTile("A1", "device.A1", width: 2, height: 1, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "yes", label: "A1", action: "A1"
            state "no", label: "unavail", action: ""
        }
        valueTile("A2", "device.A2", width: 2, height: 1, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "yes", label: "A2", action: "A2"
            state "no", label: "unavail", action: ""
        }
        valueTile("A3", "device.A3", width: 2, height: 1, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "yes", label: "A3", action: "A3"
            state "no", label: "unavail", action: ""
        }
        valueTile("A4", "device.A4", width: 2, height: 1, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "yes", label: "A4", action: "A4"
            state "no", label: "unavail", action: ""
        }
        valueTile("B1", "device.B1", width: 2, height: 1, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "yes", label: "B1", action: "B1"
            state "no", label: "unavail", action: ""
        }
        valueTile("B2", "device.B2", width: 2, height: 1, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "yes", label: "B2", action: "B2"
            state "no", label: "unavail", action: ""
        }
        valueTile("B3", "device.B3", width: 2, height: 1, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "yes", label: "B3", action: "B3"
            state "no", label: "unavail", action: ""
        }
        valueTile("B4", "device.B4", width: 2, height: 1, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "yes", label: "B4", action: "B4"
            state "no", label: "unavail", action: ""
        }
        
	main(["switch"])
	details(["power", "Audio2Ch","Audio51Ch",
             "AudioAdv","AudioArc","AudioSpdif",
             "A1","A2","A3",
             "A4","B1","B2",
             "B3","B4"])
        
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

def Audio2Ch() {
	log.debug "Executing 'Audio2Ch'"
	parent.command(this, "Audio2Ch")
}

def Audio51Ch() {
	log.debug "Executing 'Audio 5.1Ch'"
	parent.command(this, "Audio51Ch")
}

def AudioAdv() {
	log.debug "Executing 'Audio Adv'"
	parent.command(this, "AudioAdv")
}

def AudioArc() {
	log.debug "Executing 'Audio Arc'"
	parent.command(this, "AudioArc")
}

def AudioSpdif() {
	log.debug "Executing 'Audio Spdif'"
	parent.command(this, "AudioSpdif")
}

def A1() {
	log.debug "Executing 'A1'"
	parent.command(this, "A1")
}

def A2() {
	log.debug "Executing 'A2'"
	parent.command(this, "A2")
}

def A3() {
	log.debug "Executing 'A3'"
	parent.command(this, "A3")
}

def A4() {
	log.debug "Executing 'A4'"
	parent.command(this, "A4")
}

def B1() {
	log.debug "Executing 'B1'"
	parent.command(this, "B1")
}

def B2() {
	log.debug "Executing 'B2'"
	parent.command(this, "B2")
}

def B3() {
	log.debug "Executing 'B3'"
	parent.command(this, "B3")
}

def B4() {
	log.debug "Executing 'B4'"
	parent.command(this, "B4")
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