(ns jsx-to-cljs.test-cases
  (:require  [cljs.test :as t :include-macros true]))

(def t0
  "<a x={styles}><b>here</b></a>")

(def t1
  "<View style={styles.container}>
     <TouchableWithoutFeedback onPressIn={this._onPressIn}
                               onPressOut={this._onPressOut}>
       <Image source={{uri: imageUri}} style={imageStyle} />
     </TouchableWithoutFeedback>
   </View>")

(def t2
  "<Table>
    <TableHeader>
      <TableRow>
        <TableHeaderColumn value={this.state.firstSlider}>ID</TableHeaderColumn>
        <TableHeaderColumn>Name</TableHeaderColumn>
        <TableHeaderColumn>Status</TableHeaderColumn>
      </TableRow>
    </TableHeader>
    <TableBody>
      <TableRow>
        <TableRowColumn>1</TableRowColumn>
        <TableRowColumn>John Smith</TableRowColumn>
        <TableRowColumn>Employed</TableRowColumn>
      </TableRow>
      <TableRow>
        <TableRowColumn>2</TableRowColumn>
        <TableRowColumn>Randal White</TableRowColumn>
        <TableRowColumn>Unemployed</TableRowColumn>
      </TableRow>
      <TableRow>
        <TableRowColumn>3</TableRowColumn>
        <TableRowColumn>Stephanie Sanders</TableRowColumn>
        <TableRowColumn>Employed <b>Google Inc.</b></TableRowColumn>
      </TableRow>
      <TableRow>
        <TableRowColumn>4</TableRowColumn>
        <TableRowColumn>Steve Brown</TableRowColumn>
        <TableRowColumn>Employed</TableRowColumn>
      </TableRow>
    </TableBody>
  </Table>")

(def t3
  "<div style={this.style}>
     <Slider
       defaultValue={0.5}
       value={this.state.firstSlider}
       onChange={this.handleFirstSlider.bind(this)}
     />
     <p>
       <span>{'The value of this slider is: '}</span>
       <span>{this.state.firstSlider}</span>
       <span>{' from a range of 0 to 1 inclusive'}</span>
     </p>
     <Slider
       min={0}
       max={100}
       step={1}
       defaultValue={50}
       value={this.state.secondSlider}
       onChange={this.handleSecondSlider.bind(this)}
     />
     <p>
       <span>{'The value of this slider is: '}</span>
       <span>{this.state.secondSlider}</span>
       <span>{' from a range of 0 to 100 inclusive'}</span>
     </p>
   </div>")

(def t4
  "<AppBar
    title={<span style={styles.title}>Title</span>}
    onTitleTouchTap={handleTouchTap}
    iconElementLeft={<IconButton><NavigationClose /></IconButton>}
    iconElementRight={<FlatButton label=\"Save\" />}  />")

(def t5
  "<AppBar
    title=\"Title\"
    iconElementLeft={<IconButton><NavigationClose /></IconButton>}
    iconElementRight={
      <IconMenu
        iconButtonElement={
          <IconButton><MoreVertIcon /></IconButton>
        }
        targetOrigin={{horizontal: 'right', vertical: 'top'}}
        anchorOrigin={{horizontal: 'right', vertical: 'top'}}
      >
        <MenuItem primaryText=\"Refresh\" />
        <MenuItem primaryText=\"Help\" />
        <MenuItem primaryText=\"Sign out\" />
      </IconMenu>
    }
  />")

(def t6
  "<div>
     <AutoComplete
       hintText=\"Type anything\"
       dataSource={this.state.dataSource}
       onUpdateInput={this.handleUpdateInput}
     />
     <AutoComplete
       hintText=\"Type anything\"
       dataSource={this.state.dataSource}
       onUpdateInput={this.handleUpdateInput}
       floatingLabelText=\"Full width\"
       fullWidth={true}
     />
   </div>")

(def t8
  "<Card>
    <CardHeader
      title=\"URL Avatar\"
      subtitle=\"Subtitle\"
      avatar=\"http://lorempixel.com/100/100/nature/\"
    />
    <CardMedia
      overlay={<CardTitle title=\"Overlay title\" subtitle=\"Overlay subtitle\" />}
    >
      <img src=\"http://lorempixel.com/600/337/nature/\" />
    </CardMedia>
    <CardTitle title=\"Card title\" subtitle=\"Card subtitle\" />
    <CardText>
      Lorem ipsum dolor sit amet, consectetur adipiscing elit.
      Donec mattis pretium massa. Aliquam erat volutpat. Nulla facilisi.
      Donec vulputate interdum sollicitudin. Nunc lacinia auctor quam sed pellentesque.
      Aliquam dui mauris, mattis quis lacus id, pellentesque lobortis odio.
    </CardText>
    <CardActions>
      <FlatButton label=\"Action1\" />
      <FlatButton label=\"Action2\" />
    </CardActions>
  </Card>")

(def t9
  "<Animated.Image
     source={{uri: 'http://i.imgur.com/XMKOH81.jpg'}}
     style={{
        flex: 1,
        transform: [
                   {scale: this.state.bounceValue},
    ]
        }}
     />")

(def t10
  "<DatePicker
      hintText=\"Custom date format\"
      firstDayOfWeek={0}
      formatDate={new DateTimeFormat('en-US', {
        day: 'numeric',
        month: 'long',
        year: 'numeric',
      }).format}
    />")

(def t11
  "<div style={{width: 380, height: 400, margin: 'auto'}}>
     <Stepper activeStep={stepIndex} orientation=\"vertical\">
       <Step>
         <StepLabel>Select campaign settings</StepLabel>
         <StepContent>
           <p>
             For each ad campaign that you create, you can control how much
             you're willing to spend on clicks and conversions, which networks
             and geographical locations you want your ads to show on, and more.
           </p>
           {this.renderStepActions(0)}
         </StepContent>
       </Step>
       <Step>
         <StepLabel>Create an ad group</StepLabel>
         <StepContent>
           <p>An ad group contains one or more ads which target a shared set of keywords.</p>
           {this.renderStepActions(1)}
         </StepContent>
       </Step>
       <Step>
         <StepLabel>Create an ad</StepLabel>
         <StepContent>
           <p>
             Try out different ad text to see what brings in the most customers,
             and learn how to enhance your ads using features like ad extensions.
             If you run into any problems with your ads, find out how to tell if
             they're running and how to resolve approval issues.
           </p>
           {this.renderStepActions(2)}
         </StepContent>
       </Step>
     </Stepper>
     {finished && (
       <p style={{margin: '20px 0', textAlign: 'center'}}>
         <a
           href=\"#\"
           onClick={(event) => {
             event.preventDefault();
             this.setState({stepIndex: 0, finished: false});
           }}
         >
           Click here
         </a> to reset the example.
       </p>
     )}
   </div>")

(def t12
  "<div style={{margin: '12px 0'}}>
     <RaisedButton
       label={stepIndex === 2 ? 'Finish' : 'Next'}
       disableTouchRipple={true}
       disableFocusRipple={true}
       primary={true}
       onTouchTap={this.handleNext}
       style={{marginRight: 12}}
     />
     {step > 0 && (
       <FlatButton
         label=\"Back\"
         disabled={stepIndex === 0}
         disableTouchRipple={true}
         disableFocusRipple={true}
         onTouchTap={this.handlePrev}
       />
     )}
   </div>")

(def t13
  "<tbody>
    {data.map(function(item, idx){
      return <TableRow key={idx} data={item} columns={columns}/>;
    })}
   </tbody>")

(def t14
  "<Component {...props} foo={'override'} />;")

(def t15
  " <Nav>
    {/* child comment, put {} around */}
    <Person
      /* multi
         line
         comment */
      name={window.isLoggedIn ? window.name : ''} // end of line comment
    />
  </Nav>")

(def t16
  "<tr key={i}>
     {row.map(function(col, j) {
       return <td key={j}>{col}</td>;
     })}
   </tr>")

(def t17
  "<div style={styles.root}>
    <GridList
      cellHeight={200}
      style={styles.gridList}
    >
      <Subheader>December</Subheader>
      {tilesData.map((tile) => (
        <GridTile
          key={tile.img}
          title={tile.title}
          subtitle={<span>by <b>{tile.author}</b></span>}
          actionIcon={<IconButton><StarBorder color=\"white\" /></IconButton>}
        >
          <img src={tile.img} />
        </GridTile>
      ))}
    </GridList>
  </div>")

(def t18
  "<div>
     <RaisedButton
       onTouchTap={this.handleTouchTap}
       label=\"Click me\"
     />
     <h3 style={styles.h3}>Current Settings</h3>
     <pre>
       anchorOrigin: {JSON.stringify(this.state.anchorOrigin)}
       <br />
       targetOrigin: {JSON.stringify(this.state.targetOrigin)}
     </pre>
     <h3 style={styles.h3}>Position Options</h3>
     <p>Use the settings below to toggle the positioning of the popovers above</p>
     <h3 style={styles.h3}>Anchor Origin</h3>
     <div style={styles.block}>
       <div style={styles.block2}>
         <span>Vertical</span>
         <RadioButton
           onClick={this.setAnchor.bind(this, 'vertical', 'top')}
           label=\"Top\" checked={this.state.anchorOrigin.vertical === 'top'}
         />
         <RadioButton
           onClick={this.setAnchor.bind(this, 'vertical', 'center')}
           label=\"Center\" checked={this.state.anchorOrigin.vertical === 'center'}
         />
         <RadioButton
           onClick={this.setAnchor.bind(this, 'vertical', 'bottom')}
           label=\"Bottom\" checked={this.state.anchorOrigin.vertical === 'bottom'}
         />
       </div>
       <div style={styles.block2}>
         <span>Horizontal</span>
         <RadioButton
           onClick={this.setAnchor.bind(this, 'horizontal', 'left')}
           label=\"Left\" checked={this.state.anchorOrigin.horizontal === 'left'}
         />
         <RadioButton
           onClick={this.setAnchor.bind(this, 'horizontal', 'middle')}
           label=\"Middle\" checked={this.state.anchorOrigin.horizontal === 'middle'}
         />
         <RadioButton
           onClick={this.setAnchor.bind(this, 'horizontal', 'right')}
           label=\"Right\" checked={this.state.anchorOrigin.horizontal === 'right'}
         />
       </div>
     </div>
     <h3 style={styles.h3}>Target Origin</h3>
     <div style={styles.block}>
       <div style={styles.block2}>
         <span>Vertical</span>
         <RadioButton
           onClick={this.setTarget.bind(this, 'vertical', 'top')}
           label=\"Top\" checked={this.state.targetOrigin.vertical === 'top'}
         />
         <RadioButton
           onClick={this.setTarget.bind(this, 'vertical', 'center')}
           label=\"Center\" checked={this.state.targetOrigin.vertical === 'center'}
         />
         <RadioButton
           onClick={this.setTarget.bind(this, 'vertical', 'bottom')}
           label=\"Bottom\" checked={this.state.targetOrigin.vertical === 'bottom'}
         />
       </div>
       <div style={styles.block2}>
         <span>Horizontal</span>
         <RadioButton
           onClick={this.setTarget.bind(this, 'horizontal', 'left')}
           label=\"Left\" checked={this.state.targetOrigin.horizontal === 'left'}
         />
         <RadioButton
           onClick={this.setTarget.bind(this, 'horizontal', 'middle')}
           label=\"Middle\" checked={this.state.targetOrigin.horizontal === 'middle'}
         />
         <RadioButton
           onClick={this.setTarget.bind(this, 'horizontal', 'right')}
           label=\"Right\" checked={this.state.targetOrigin.horizontal === 'right'}
         />
       </div>
     </div>
     <Popover
       open={this.state.open}
       anchorEl={this.state.anchorEl}
       anchorOrigin={this.state.anchorOrigin}
       targetOrigin={this.state.targetOrigin}
       onRequestClose={this.handleRequestClose}
     >
       <Menu>
         <MenuItem primaryText=\"Refresh\" />
         <MenuItem primaryText=\"Help &amp; feedback\" />
         <MenuItem primaryText=\"Settings\" />
         <MenuItem primaryText=\"Sign out\" />
       </Menu>
     </Popover>
   </div>")

(def t19
  "<div>
        <SelectField
          value={value}
          onChange={this.handleChange}
          errorText={!night && 'Should be Night'}
        >
          {items}
        </SelectField>
        <br />
        <SelectField
          value={value}
          onChange={this.handleChange}
          errorText={night && 'Should not be Night (Custom error style)'}
          errorStyle={{color: 'orange'}}
        >
          {items}
        </SelectField>
      </div>")

(def t20
  "<div id=\"my-id\" className=\"some-class some-other\"><span className={styles.span}><b className={\"home\"}>Home</b></span></div>")

(def t21
  "<View style={styles.container}>
     <View style={[styles.box, {width: this.state.w, height: this.state.h}]} />
     <TouchableOpacity onPress={this._onPress}>
       <View style={styles.button}>
         <Text style={styles.buttonText}>Press me!</Text>
       </View>
     </TouchableOpacity>
   </View>")

(def t22
  "<View style={{flex: 1, justifyContent: 'center', alignItems: 'center'}}>
     <TouchableWithoutFeedback onPress={this._animateOpacity}>
       <View ref={component => this._box = component}
             style={{width: 200, height: 200, backgroundColor: 'red',
                     opacity: this.getTweeningValue('opacity')}} />
     </TouchableWithoutFeedback>
   </View>")

(def t23
  "<View>
     <Modal
       animated={this.state.animated}
       transparent={this.state.transparent}
       visible={this.state.modalVisible}
       onRequestClose={() => {this._setModalVisible(false)}}
       >
       <View style={[styles.container, modalBackgroundStyle]}>
         <View style={[styles.innerContainer, innerContainerTransparentStyle]}>
           <Text>This modal was presented {this.state.animated ? 'with' : 'without'} animation.</Text>
           <Button
             onPress={this._setModalVisible.bind(this, false)}
             style={styles.modalButton}>
             Close
           </Button>
         </View>
       </View>
     </Modal>

     <View style={styles.row}>
       <Text style={styles.rowTitle}>Animated</Text>
       <Switch value={this.state.animated} onValueChange={this._toggleAnimated} />
     </View>

     <View style={styles.row}>
       <Text style={styles.rowTitle}>Transparent</Text>
       <Switch value={this.state.transparent} onValueChange={this._toggleTransparent} />
     </View>

     <Button onPress={this._setModalVisible.bind(this, true)}>
       Present
     </Button>
   </View>")

(def t24
  "<Navigator
   initialRoute={{name: 'My First Scene', index: 0}}
   renderScene={(route, navigator) =>
     <MySceneComponent
       name={route.name}
       onForward={() => {
         var nextIndex = route.index + 1,
\t       myVar = \"sth\";
\tvar prevIndex = route.index - 1;
         navigator.push({
           name: 'Scene ' + nextIndex,
           index: nextIndex,
         });
       }}
       onBack={() => {
         if (route.index > 0) {
           navigator.pop();
         }
       }}
     />
   }
 />")

(def t25
  "<ul>
     {this.props.results.map(function(result) {
        return <ListItemWrapper data={result}/>;
      })}
   </ul>")

(def t26
  "<View>
        <Text>Please choose a make for your car:</Text>
        <PickerIOS
          selectedValue={this.state.carMake}
          onValueChange={(carMake) => this.setState({carMake, modelIndex: 0})}>
          {Object.keys(CAR_MAKES_AND_MODELS).map((carMake) => (
            <PickerItemIOS
              key={carMake}
              value={carMake}
              label={CAR_MAKES_AND_MODELS[carMake].name}
            />
          ))}
        </PickerIOS>
        <Text>Please choose a model of {make.name}:</Text>
        <PickerIOS
          selectedValue={this.state.modelIndex}
          key={this.state.carMake}
          onValueChange={(modelIndex) => this.setState({modelIndex})}>
          {CAR_MAKES_AND_MODELS[this.state.carMake].models.map((modelName, modelIndex) => (
            <PickerItemIOS
              key={this.state.carMake + '_' + modelIndex}
              value={modelIndex}
              label={modelName}
            />
          ))}
        </PickerIOS>
        <Text>You selected: {selectionString}</Text>
      </View>")

(def t27
  "< Navigator initialRoute = {
    {
      name: 'My First Scene',
      index: 0
    }
  }
  renderScene = {
    (route, navigator) =>
    < MySceneComponent
    name = {
      route.name
    }
    onForward = {
      () => {
        var nextIndex = route.index + 1,
          myOtherIndex = nextIndex + 10;

        navigator.push({
          name: 'Scene ' + nextIndex,
          index: nextIndex,
        });

        var yetAnotherIndex = myOtherIndex - 1;
      }
    }
    onBack = {
      () => {
        if (route.index > 0) {
          navigator.pop();
        } else if (route.index == 0) {
          someFuction();
          namingIsHardFun();
        } else {
        \tvar myGreatParam = 5;
          someOtherFunction(myGreatParam);
        }
      }
    }
    />
  }
  />")

(def t28
  "<View>
     <ScrollView
       ref={(scrollView) => { _scrollView = scrollView; }}
       automaticallyAdjustContentInsets={false}
       onScroll={() => { console.log('onScroll!'); }}
       scrollEventThrottle={200}
       style={styles.scrollView}>
       {THUMBS.map(createThumbRow)}
     </ScrollView>
     <TouchableOpacity
       style={styles.button}
       onPress={() => { _scrollView.scrollTo({y: 0}); }}>
       <Text>Scroll to top</Text>
     </TouchableOpacity>
   </View>")

(def t29
  "<Animated.View
     {...this.state.panResponder.panHandlers}
     style={this.state.pan.getLayout()}>
     {this.props.children}
   </Animated.View>")

(def t30
  "<TextInput
    style={[styles, {height: 40, borderColor: 'gray', borderWidth: 1}, {borderColor: 'blue'}]}
    onChangeText={(text) => this.setState({text})}
    value={this.state.text}
  />")

(def t31
  "function _onPress(someParam, someOther) {
    // Animate the update
 var a = 1;
    LayoutAnimation.spring();
    this.setState({w: this.state.w + 15, h: this.state.h + 15})
  }")

(def t32
  "var leftStyle = this.state.index === 0 ? {flex: 1} : {width: 20};
   var middleStyle = this.state.index === 2 ? {width: 20} : {flex: 1};")

(def t33
  "const myConst = {some: 34};

function explode(size) {
\tvar earth = \"planet\";
\tvar foo = \"bar\";
\treturn boom(earth) * size + myConst;
}

explode(42);")

(def t34
  "function isDropZone(gesture){     //Step 2
     var dz = this.state.dropZoneValues;
     return gesture.moveY > dz.y && gesture.moveY < dz.y + dz.height;
   }")
