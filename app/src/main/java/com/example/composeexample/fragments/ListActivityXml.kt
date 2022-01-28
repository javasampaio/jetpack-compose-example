package com.example.composeexample.fragments

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.example.composeexample.ListViewModel
import com.example.composeexample.R
import com.example.composeexample.components.ListCardMessage
import com.example.composeexample.databinding.ListActivityBinding
import com.example.composeexample.model.Message
import com.example.composeexample.ui.theme.ComposeExampleTheme
import com.example.composeexample.views.ListView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import org.koin.android.ext.android.inject

class ListActivityXml : AppCompatActivity() {

    private val viewModel: ListViewModel by inject()

    private lateinit var binding: ListActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ListActivityBinding.inflate(layoutInflater)
        setComposeView()
        setupListener()
        setContentView(binding.root)
    }

    private fun setupListener() {
        binding.addFab.setOnClickListener {
            viewModel.addNewMessage()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        binding.addFab.show()
    }

    private fun setComposeView() {
        binding.composeViewList.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                ComposeExampleTheme {
                    ListCardMessage(
                        messages = viewModel.messages,
                        onItemClick = {
                            navigateToDetails(it)
                            binding.addFab.shrink(object :
                                ExtendedFloatingActionButton.OnChangedCallback() {
                                override fun onShrunken(extendedFab: ExtendedFloatingActionButton?) {
                                    super.onShrunken(extendedFab)
                                    binding.addFab.hide()
                                }
                            }
                            )
                        }
                    )
                }
            }
        }
    }

    private fun navigateToDetails(message: Message) {
        if (supportFragmentManager.findFragmentByTag(DetailFragment.DETAIL_FRAGMENT_TAG) == null) {
            supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container,
                DetailFragment.newInstance(message),
                DetailFragment.DETAIL_FRAGMENT_TAG
            ).addToBackStack(DetailFragment.DETAIL_FRAGMENT_TAG).commit()
            return
        }

        supportFragmentManager.beginTransaction().add(
            R.id.fragment_container,
            DetailFragment.newInstance(message),
            DetailFragment.DETAIL_FRAGMENT_TAG
        ).addToBackStack(DetailFragment.DETAIL_FRAGMENT_TAG).commit()
    }
}