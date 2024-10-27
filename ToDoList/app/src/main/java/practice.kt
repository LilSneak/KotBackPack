class practice {
    public void handleClick(View v)
    {
        switch(v.getId()) {
            case R . id . buttonAddToDo :
            Intent addTask = new Intent(this, EditTaskActivity.class);
            break;
        }
    }
}