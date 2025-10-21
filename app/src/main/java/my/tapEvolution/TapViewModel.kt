package my.tapEvolution

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class TapViewModel : ViewModel(){
    private val _food = MutableStateFlow(0)
    private val _wood = MutableStateFlow(0)
    private val _stone = MutableStateFlow(0)
    private val _population = MutableStateFlow(0)
    //Produces:Food   Wood       Stone     Skin   Faith  Herb   Leather Horse    Wonders(future use) Copper      Knowledge Iron      Sand(future use)
    //  listOf(Farmer,Woodcutter,Quarryman,Hunter,Priest,Doctor,Tanner, Wrangler,Laborer(Not in use),Coppersmith,Scholar,  Ironsmith,Sand Miner(Not in use))
    private val _workers = MutableStateFlow<List<Int>>(listOf(0,0,0,0,0,0,0,0,0,0,0,0,0))
    private val _unemployed = MutableStateFlow(_population.value - _workers.value.sum())
        //Same order as the workers
    private val _resourceCaps=MutableStateFlow<List<Int>>(listOf(1000,1000,1000,100,100,100,100,100,100,100,100,100,100))
    private val _popCap = MutableStateFlow(0)
    //       Population Cap                       Food Cap                 Wood and stone cap          Skin cap     Leather  Horse   Copper cap     Faith  Herb   Knowledge Iron cap     Happiness (future use)   Spearman   Archer cap     Warrior Rider cap
    //ListOf(Hut,Chalet,Farmhouse,House,Courtyard,Granary,Logistics Center,Warehouse,Strategic Storage,Hunter Cabin,Curriery,Pasture,Copper Smelter,Temple,Clinic,Library,  Iron Smelter,Bath Pool,Tavern,Theater,Guardhouse,Shooting Range,Barrack,Training Ground)
    private val _buildings = MutableStateFlow<List<Int>>(listOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0))
    private val _landFree = MutableStateFlow(2000)
    private val _territory = MutableStateFlow(2000)
    //ListOf(spearmen, archers, warriors, riders)
    private val _warriors = MutableStateFlow<List<Int>>(listOf(0,0,0,0))
    //ListOf(IdleWood,IdleFood,IdleStone,Land,TapWood,TapFood,TapStone)
    private val _multipliers = MutableStateFlow<List<Double>>(listOf(1.0,2.0,1.0,1.0,1.0,1.0,1.0))
    val food = _food.asStateFlow()
    val wood = _wood.asStateFlow()
    val stone = _stone.asStateFlow()
    val unemployed = _unemployed.asStateFlow()
    val workers = _workers.asStateFlow()
    val territory = _territory.asStateFlow()
    val freeland = _landFree.asStateFlow()

    fun updateBasicResources(){
        _wood.value  += (_workers.value[1] * _multipliers.value[0]).toInt()
        if(_wood.value>_resourceCaps.value[1]){
            _wood.value -= (_wood.value - _resourceCaps.value[1])
        }
        _food.value += (_workers.value[0] * _multipliers.value[1]).toInt()
        _food.value -= _population.value
        if(_food.value>_resourceCaps.value[0]){
            _food.value -= (_food.value - _resourceCaps.value[0])
        }
        if(_food.value < 0){
            _food.value = 0
        }
        _stone.value += (_workers.value[2] * _multipliers.value[2]).toInt()
        if(_stone.value>_resourceCaps.value[2]){
            _stone.value -= (_stone.value - _resourceCaps.value[2])
        }
    }

    fun updateLand(){
        _landFree.value += (60 * _multipliers.value[3]).toInt()
        _territory.value += (60 * _multipliers.value[3]).toInt()
    }

    fun addPop(){
        if(_population.value < _popCap.value && _food.value >= 10){
            _population.value += 1
            _food.value -= 10
            _unemployed.value = _population.value - _workers.value.sum()
        }
    }

    fun hireFarmer(){
        if(_unemployed.value > 0){
            val updateList = _workers.value.toMutableList()
            updateList[0] += 1
            _workers.value = updateList
            _unemployed.value = _population.value - _workers.value.sum()
        }
    }

    fun hireWoodcutter(){
        if(_unemployed.value > 0){
            val updateList = _workers.value.toMutableList()
            updateList[1] += 1
            _workers.value = updateList
            _unemployed.value = _population.value - _workers.value.sum()
        }
    }

    fun hireQuarryman(){
        if(_unemployed.value > 0){
            val updateList = _workers.value.toMutableList()
            updateList[2] += 1
            _workers.value = updateList
            _unemployed.value = _population.value - _workers.value.sum()
        }
    }

    fun buyHut(){
        if(_landFree.value >= 5 && _wood.value >= 5){
            _landFree.value -= 5
            _wood.value -= 5
            _popCap.value += 1
            val updatedList = _buildings.value.toMutableList()
            updatedList[0] += 1
            _buildings.value = updatedList
        }
    }



    fun tapWood(){
        _wood.value  += (1 * _multipliers.value[4]).toInt()
        if(_wood.value>_resourceCaps.value[1]){
            _wood.value -= (_wood.value - _resourceCaps.value[1])
        }
    }

    fun tapFood(){
        _food.value  += (1 * _multipliers.value[5]).toInt()
        if(_food.value>_resourceCaps.value[0]){
            _food.value -= (_food.value - _resourceCaps.value[0])
        }
    }

    fun tapStone(){
        _stone.value += (1 * _multipliers.value[6]).toInt()
        if(_stone.value>_resourceCaps.value[2]){
            _stone.value -= (_stone.value - _resourceCaps.value[2])
        }
    }

    suspend fun npcResource(){
        while(true){
            delay(15000)
            updateBasicResources()
            delay(15000)
            updateBasicResources()
            delay(15000)
            updateBasicResources()
            delay(15000)
            updateBasicResources()
            delay(15000)
            updateBasicResources()
            delay(15000)
            updateBasicResources()
            delay(15000)
            updateBasicResources()
            delay(15000)
            updateBasicResources()
            delay(15000)
            updateBasicResources()
            delay(15000)
            updateBasicResources()
            delay(15000)
            updateBasicResources()
            delay(15000)
            updateBasicResources()
            delay(15000)
            updateBasicResources()
            delay(15000)
            updateBasicResources()
            delay(15000)
            updateBasicResources()
            delay(15000)
            updateBasicResources()
            delay(15000)
            updateBasicResources()
            delay(15000)
            updateBasicResources()
            delay(15000)
            updateBasicResources()
            delay(15000)
            updateBasicResources()
            updateLand()
        }
    }

    fun init() {
        viewModelScope.launch {
            npcResource()
        }
    }
}