package com.facebook.sdk.sample

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.facebook.sdk.lite.api.FacebookLiteApiClient
import com.facebook.sdk.lite.api.FacebookLiteApiClientBuilder
import com.facebook.sdk.lite.auth.FacebookLoginApi
import com.facebook.sdk.sample.databinding.FragmentApiBinding

class FacebookApisFragment : Fragment() {
    private var _binding: FragmentApiBinding? = null
    private val binding get() = _binding!!

    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private lateinit var apiClient: FacebookLiteApiClient

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentApiBinding.inflate(inflater, container, false)
        return binding.root
        //return inflater.inflate(R.layout.fragment_api, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //event listener
        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            Log.d(TAG, "result code: ${it.resultCode}")
            when(it.resultCode){
                0 -> {
                    //val result = FacebookLoginApi.getGoogleLoginResultFromIntent(it.data)
                    addLog("result.toString()")
                }
                1 -> {
                    //val result = FacebookLoginApi.getFacebookLoginResultFromIntent(it.data)
                    addLog("result.toString()")
                }
                2 -> {
                    //val result = FacebookLoginApi.getAppleLoginResultFromIntent(it.data)
                    addLog("result.toString()")
                }
            }
        }

        apiClient = activity?.let { FacebookLiteApiClientBuilder(it).build() }!!

        apiClient.setupSDK()

        binding.facebookLoginBtn.setOnClickListener {
            addLog("fb login success")

//            val loginIntent = context?.let {
//                UniversalLoginApi.getFacebookLoginIntent(it)
//            }
//            resultLauncher.launch(loginIntent)
        }

//        binding.logoutBtn.setOnClickListener {
//            apiClient.logout(requireActivity())
//        }
//
//        binding.customTabViewBtn.setOnClickListener {
//            apiClient.openCustomTabView(requireActivity(), "https://www.naver.com")
//        }
//
//        binding.popupDialogBtn.setOnClickListener {
//            addLog("popup open")
//        }
//
//        binding.imgBannerBtn.setOnClickListener {
//            apiClient.openImageBanner(requireActivity())
//        }

        binding.clearLogBtn.setOnClickListener {
            binding.log.text = ""
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun addLog(logText: String) {
        binding.log.text = logText.plus("\n" + binding.log.text)

        Log.d(TAG, "log: $logText")
        //println(logText)
    }

    companion object {
        private const val TAG = "FacebookApisFragment"
    }
}