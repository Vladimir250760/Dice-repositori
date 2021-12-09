package example.vladimir.myprojectexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import kotlin.random.Random


private const val LAST_SELECTED_ROLLED_IMAGE="image"
class DiceRollFragment : Fragment() {

    lateinit var diceImageView: ImageView
    lateinit var rollButton: Button

    private val diceImageList: List<Int> = listOf(
        R.drawable.dice1,
        R.drawable.dice2,
        R.drawable.dice3,
        R.drawable.dice4,
        R.drawable.dice5,
        R.drawable.dice6,
    )


    val lastRolledImageRes=0




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInsanceState: Bundle?

    ): View? {
        val view = inflater.inflate(R.layout.fragment_dice_roll, container, false)

        diceImageView = view.findViewById(R.id.dice_image_view)
        rollButton = view.findViewById(R.id.roll_button)

        if (savedInsanceState!=null)
            diceImageView.setImageResource(savedInsanceState.getInt(LAST_SELECTED_ROLLED_IMAGE))

        rollButton.setOnClickListener {
            lastRolledImageRes=diceImageList.random()
            diceImageView.setImageResource(lastRolledImageRes)

        }


        return view

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LAST_SELECTED_ROLLED_IMAGE,lastRolledImageRes)
    }

}