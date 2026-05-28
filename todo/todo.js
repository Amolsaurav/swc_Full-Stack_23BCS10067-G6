const form  = document.getElementById('todo-form');
const input = document.getElementById('todo-input');
const list = document.getElementById('todo-list');
const completedList = document.getElementById('completed-tasks');
const activeList = document.getElementById('active-tasks');
let activeTasks=[];
let completedTasks=[];

form.addEventListener('submit',(e)=>{
    e.preventDefault();
    addTask();
})

function addTask(){
    const task = input.value.trim();
    if(task !== ''){
        const li = document.createElement('li');
        li.textContent = task;
        const completeBtn = document.createElement('button');
        completeBtn.textContent = 'Complete';
        completeBtn.addEventListener('click',()=>{
            completeTask(li,task);
            renderCompletedTasks();
            renderActiveTasks();
        });

        const deleteBtn = document.createElement('button');
        deleteBtn.textContent = 'Delete';
        deleteBtn.addEventListener('click',()=>{
            deleteTask(li,task);
        })
        li.appendChild(completeBtn);
        li.appendChild(deleteBtn);
        list.appendChild(li);
        activeTasks.push(task);
        renderActiveTasks();
        input.value='';
    }
}

function completeTask(li,task){
    completedTasks.push(task);
    activeTasks = activeTasks.filter(t=> t!=task);
    li.remove();
}

function deleteTask(li,task){
    activeTasks = activeTasks.filter(t=> t!=task);
    completedTasks = completedTasks.filter(t=> t!=task);
    li.remove();
    renderActiveTasks();
}

function renderCompletedTasks(){
    completedList.innerHTML='';
    completedTasks.forEach(task=>{
        const li = document.createElement('li');
        li.textContent = task;
        completedList.appendChild(li);
    }
    );
}

function renderActiveTasks(){
    activeList.innerHTML='';
    activeTasks.forEach(task=>{
        const li = document.createElement('li');
        li.textContent = task;
        activeList.appendChild(li);
    }
    );
}

