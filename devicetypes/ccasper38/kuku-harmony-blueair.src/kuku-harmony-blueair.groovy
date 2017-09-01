/**
 *  KuKu Harmony_Blueair
 *
 *  Copyright 2017 KuKu
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
	definition (name: "KuKu Harmony_Blueair", namespace: "ccasper38", author: "berkeros") {
		capability "Actuator"
		capability "Configuration"
		capability "Health Check"
		capability "Refresh"
		capability "Sensor"
		capability "Switch"

		command "power"
		command "minus"
		command "plus"
		command "timer"
		command "speed"
		command "preset"
	}

	tiles (scale: 2){      
		multiAttributeTile(name:"switch", type: "generic", width: 6, height: 4, canChangeIcon: true){
			tileAttribute ("device.switch", key: "PRIMARY_CONTROL") {
				attributeState "off", label:'${name}', action:"switch.on", backgroundColor:"#ffffff", icon: "st.switches.switch.off", nextState:"turningOn"
                attributeState "on", label:'${name}', action:"switch.off", backgroundColor:"#79b821", icon: "st.switches.switch.on", nextState:"turningOff"
				attributeState "turningOn", label:'${name}', action:"switch.off", backgroundColor:"#79b821", icon: "st.switches.switch.off", nextState:"turningOff"
				attributeState "turningOff", label:'${name}', action:"switch.on", backgroundColor:"#ffffff", icon: "st.switches.switch.on", nextState:"turningOn"
			}
        }

        valueTile("power", "device.power", width: 2, height: 2, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "yes", label: "POWER", action: "power"
            state "no", label: "unavail", action: ""
        }
        valueTile("minus", "device.minus", width: 2, height: 2, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "yes", label: "Minus\n-", action: "minus"
            state "no", label: "unavail", action: ""
        }
        valueTile("plus", "device.plus", width: 2, height: 2, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "yes", label: "Plus\n+", action: "plus"
            state "no", label: "unavail", action: ""
        }
        
        valueTile("timer", "device.timer", width: 2, height: 2, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "yes", label: "TIMER", action: "timer"
            state "no", label: "unavail", action: ""
        }
        
        valueTile("speed", "device.speed", width: 2, height: 2, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "yes", label: "Speed", action: "speed"
            state "no", label: "unavail", action: ""
        }
        
        valueTile("preset", "device.preset", width: 2, height: 2, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "yes", label: "PRESET", action: "preset"
            state "no", label: "unavail", action: ""
        }

    }

	main(["switch"])
	details(["power", "minus", "plus",
            "speed", "timer", "preset"])
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

def speed() {
    log.debug "child speed()"
    parent.command(this, "speed")
}

def minus() {
    log.debug "child minus()"
    parent.command(this, "minus")
}

def plus() {
    log.debug "child plus()"
    parent.command(this, "plus")
}

def timer() {
    log.debug "child timer()"
    parent.command(this, "timer")
}

def preset() {
    log.debug "child preset()"
    parent.command(this, "preset")
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