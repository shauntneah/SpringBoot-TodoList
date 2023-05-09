const createHTMLList = (title, description, target) =>
      `
      <tr>
      <td>${title}</td>
      <td>${description}</td>
      <td>${target}</td>
      </tr>
      `;


class TasksController {
    constructor()
        {
            this._tasks = [];
        }

    addTask(title,description,target){
            const formData = new FormData();
            formData.append('title', title);
            formData.append('description', description);
            formData.append('target', target);

           fetch('http://localhost:8080/task/add', {
                 method: 'POST',
                 body: formData
                 })
                 .then(function(response) {
                     if (response.ok) {
                         alert("Task Successfully Added!")
                     }
                 })
                 .catch((error) => {
                     alert("Error Occurred: " + error)
                 });
        }

    displayTasks(){
        let taskController = this;

        fetch('http://127.0.0.1:8080/task/all')
            .then((resp) => resp.json())
            .then(function(data) {
                data.forEach(function (task, index) {

                    let taskDescription = "not set";
                    let taskTarget = "not set";

                    if (task.description){taskDescription = task.description;}
                    else {taskDescription = "-";}

                    if (task.target != null){
                    taskTarget = taskController.flipDate(task.target);
                    }
                    else {taskTarget = "-";}

                    const taskObj = {
                        title: task.title,
                        description: taskDescription,
                        target: taskTarget,
                    };
                    taskController._tasks.push(taskObj);
                });
                taskController.renderToDo();
            })
            .catch(function(error) {
                console.log(error);
            });

    }

    renderToDo(){
        let taskHTMLList = [];

        for (let i=0; i< this._tasks.length; i++)
        {
            const task = this._tasks[i];

            const taskHTML = createHTMLList(task.title, task.description, task.target);

            taskHTMLList.push(taskHTML);
        }

        const tHTML = taskHTMLList.join('\n');
        document.querySelector('#taskList').innerHTML = tHTML;
    }

    flipDate(date){
    let newDate = date.split("-");
    newDate = newDate.reverse();
    return newDate.join("-");
    }
}