package com.example.composeexample.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import com.example.composeexample.databinding.DetailFragmentBinding
import com.example.composeexample.model.Message
import com.example.composeexample.ui.theme.ComposeExampleTheme
import com.example.composeexample.ui.theme.dimen8Dp

class DetailFragment : Fragment() {
    private fun getMessage(): Message? = arguments?.getParcelable(MESSAGE_EXTRA)
    private lateinit var binding: DetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DetailFragmentBinding.inflate(layoutInflater)
        setComposeView()
        return binding.root
    }

    private fun setComposeView() {
        binding.composeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                ComposeExampleTheme {
                    Spacer(modifier = Modifier.height(dimen8Dp))
                    Text(text = getMessage()?.message ?: "")
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getMessage()?.let {
            binding.messageAuthor.text = it.author
        }
    }

    companion object {
        const val DETAIL_FRAGMENT_TAG = "detail_fragment_tag"
        private const val MESSAGE_EXTRA = "message_extra"
        fun newInstance(message: Message): DetailFragment {
            return DetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(MESSAGE_EXTRA, message)
                }
            }
        }
    }
}