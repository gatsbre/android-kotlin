package com.example.myapplication.ui.fragments

import android.content.pm.ActivityInfo
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myapplication.R

class SharpenFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sharpen, container, false)

        val videoView = view.findViewById<VideoView>(R.id.videoKnifeSharpen)
        val mediaController = MediaController(requireContext())
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)

        val videoUri = Uri.parse("android.resource://" + requireContext().packageName + "/" + R.raw.knife_sharpen)
        videoView.setVideoURI(videoUri)
        videoView.requestFocus()
        videoView.start()

        return view
    }
}
