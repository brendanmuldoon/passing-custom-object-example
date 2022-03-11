package com.example.passing_custom_object_example

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.passing_custom_object_example.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: PersonViewModel
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initBinding()
    }

    private fun initBinding() {
        activityMainBinding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this,
                R.layout.activity_main)
        viewModel = ViewModelProvider.AndroidViewModelFactory(application)
            .create(PersonViewModel::class.java)
        activityMainBinding.vm = viewModel
        activityMainBinding.lifecycleOwner = this
    }

    fun moveToOtherActivity(view: View) {
        System.out.println("here")
        val nextIntent = Intent(this,
            MyOtherActivity::class.java).apply {
            putExtra(Constants.SELECTED_PERSON_KEY.name, viewModel.getNewPerson())
        }
        startActivity(nextIntent)
    }
}