import { useState } from "react";
import Modal from "./Modal";
import { Button } from "./ui/button";
import { Textarea } from "./ui/textarea";

function FeedbackModal({ open, setOpen, onFeedback }) {
  const [comment, setComment] = useState();
  console.log("FeedbackModal open:", comment);
  const onClick = () => {
    if (!comment) {
      alert("Please enter feedback");
      return;
    }
    onFeedback(comment);
    setOpen(false);
    setComment("");
  };

  return (
    <Modal onClose={setOpen} isOpen={open}>
      <Textarea
        className="text-black"
        onChange={(e) => setComment(e.target.value)}
      ></Textarea>

      <Button onClick={onClick} className="w-full">
        Send Feedback
      </Button>
    </Modal>
  );
}

export default FeedbackModal;
