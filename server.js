const express = require('express');
const { exec } = require('child_process');
const mysql = require('mysql');

const app = express();
app.use(express.json());

const db = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: 'admin123',
  database: 'app',
});

// VULN: Command injection — untrusted input passed straight to a shell.
app.get('/ping', (req, res) => {
  const host = req.query.host;
  exec('ping -c 1 ' + host, (err, stdout) => {
    res.send(stdout);
  });
});

// VULN: SQL injection — string-concatenated query.
app.get('/user', (req, res) => {
  const id = req.query.id;
  db.query("SELECT * FROM users WHERE id = '" + id + "'", (err, rows) => {
    res.json(rows);
  });
});

// VULN: eval on user-supplied input.
app.post('/calc', (req, res) => {
  const expr = req.body.expr;
  const result = eval(expr);
  res.json({ result });
});

app.listen(3000);
