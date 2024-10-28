package com.nowakartur.websitechangesmonitor.monitor

import org.springframework.stereotype.Component
import java.io.BufferedInputStream
import javax.sound.sampled.AudioSystem

@Component
class SoundPlayer {

    fun playNotificationSound(audioClip: String) {
        val inputStream = javaClass.getResourceAsStream(audioClip)
        val bufferedInputStream = BufferedInputStream(inputStream)
        val audioInputStream = AudioSystem.getAudioInputStream(bufferedInputStream)
        val clip = AudioSystem.getClip()
        clip.open(audioInputStream)
        clip.start()
        Thread.sleep(clip.microsecondLength / 100)
        clip.close()
        audioInputStream.close()
    }
}
