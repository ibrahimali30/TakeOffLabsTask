package com.ibrahim.takeofflabstask

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.button.MaterialButton
import com.ibrahim.takeofflabstask.base.ViewModelFactory
import com.ibrahim.takeofflabstask.feature.presentation.viewmodel.ProfilesViewModel
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import link.fls.swipestack.SwipeStack
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

val TAG = "log app"

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<ProfilesViewModel>
    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)
            .get(ProfilesViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getProfiles()
        ObserveProfiles()
        initCardView()
        initClickActions()
    }

    private fun initClickActions() {
        findViewById<View>(R.id.btSelect).setOnClickListener {
            cardStack.swipeTopViewToLeft()
        }

        findViewById<View>(R.id.btCancel).setOnClickListener {
            cardStack.swipeTopViewToRight()
        }
    }

    lateinit var cardsAdapter: CardsAdapter
    lateinit var cardStack: SwipeStack

    private fun initCardView() {
        cardStack = findViewById<SwipeStack>(R.id.cardStack)
        cardsAdapter = CardsAdapter(this, listOf())
        cardStack.setAdapter(cardsAdapter)

        cardStack.setListener(object: SwipeStack.SwipeStackListener{
            override fun onViewSwipedToLeft(position: Int) {
                handleSelectProfile()
            }

            override fun onViewSwipedToRight(position: Int) {
                handleCandelProfile()
            }

            override fun onStackEmpty() {}


        })
    }

    private fun handleSelectProfile() {
        findViewById<MaterialButton>(R.id.btCount).apply {
            text = (text.toString().toInt()+1).toString()
        }
    }

    private fun handleCandelProfile() {
        Log.d(TAG, "handleCandelProfile: ")
    }

    private fun getProfiles() {
        viewModel.getProfiles()
    }

    private fun ObserveProfiles() {
        viewModel.profilesObservableResource.observe(this , Observer {
            cardsAdapter.updateProfiles(it)
        })
    }
}